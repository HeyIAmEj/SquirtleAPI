package br.com.squirtle.security.filter;

import br.com.squirtle.security.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String jwtAuthorizationHeader = request.getHeader("Authorization");
        String email = null;
        String jwt = null;

        if (request.getServletPath().equals("/api/v1/login")) {
            filterChain.doFilter(request, response);
        } else {
            if (jwtAuthorizationHeader != null && jwtAuthorizationHeader.startsWith("Bearer ")) {
                try {
                    jwt = jwtAuthorizationHeader.substring(7);
                    email = jwtUtils.getUsernameFromToken(jwt);

                    System.out.println(email);
                    if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
                        if (jwtUtils.validateToken(jwt, userDetails)) {
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                    email, null, new ArrayList<>()
                            );
                            /*authObject = authentication.authenticate(new UsernamePasswordAuthenticationToken(
                                    usuarioDTO.getEmail(), usuarioDTO.getSenha()
                            ));*/
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                            filterChain.doFilter(request, response);
                        }
                    } else {
                        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                        HashMap<String, String> responsebody = new HashMap<>();
                        responsebody.put("status", String.valueOf(HttpStatus.FORBIDDEN.value()));
                        responsebody.put("message", "Token invalido");

                        response.getOutputStream().print(new ObjectMapper().writeValueAsString(responsebody));
                        response.flushBuffer();
                    }
                } catch (Exception exception) {
                    response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    HashMap<String, String> responsebody = new HashMap<>();
                    responsebody.put("status", String.valueOf(HttpStatus.FORBIDDEN.value()));
                    responsebody.put("message", exception.getMessage());

                    response.getOutputStream().print(new ObjectMapper().writeValueAsString(responsebody));
                    response.flushBuffer();
                    //response.sendError(HttpStatus.FORBIDDEN.value());

                }
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
