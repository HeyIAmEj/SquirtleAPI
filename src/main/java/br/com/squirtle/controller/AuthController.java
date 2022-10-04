package br.com.squirtle.controller;

import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.dto.response.ResponseBody;
import br.com.squirtle.security.JWTUtils;
import br.com.squirtle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authentication;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping()
    public ResponseBody auth(@RequestBody UsuarioDTO usuarioDTO){
        Authentication authObject;
        ResponseBody responseBody = new ResponseBody();
        try{
            authObject = authentication.authenticate(new UsernamePasswordAuthenticationToken(
                    usuarioDTO.getEmail(), usuarioDTO.getSenha()
            ));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        }catch (Exception exception){
            System.out.println("Exception");
            responseBody.setStatus(String.valueOf(HttpStatus.FORBIDDEN));
            HashMap<String, String> response = new HashMap<>();
            response.put("status", String.valueOf(HttpStatus.FORBIDDEN));
            response.put("message", exception.getMessage());
            responseBody.setResponse(response);
            return responseBody;
        }

        String email = authObject.getName();

        UserDetails userDetails = usuarioService.loadUserByUsername(email);
        String jwt = jwtUtils.generateToken(userDetails);

        responseBody.setStatus(String.valueOf(HttpStatus.OK));
        HashMap<String, String> response = new HashMap<>();
        response.put("jwt", jwt);
        responseBody.setResponse(response);

        return responseBody;
    }
}
