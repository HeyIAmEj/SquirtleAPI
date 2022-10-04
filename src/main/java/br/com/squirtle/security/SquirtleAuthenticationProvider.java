package br.com.squirtle.security;

import br.com.squirtle.model.Usuario;
import br.com.squirtle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SquirtleAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String senha = authentication.getCredentials().toString();

        boolean userExists = usuarioRepository.existsUsuarioByEmail(email);
        if(userExists){
            Usuario usuario = usuarioRepository.findByEmail(email);
            if(passwordEncoder.matches(senha, usuario.getSenha())){
                return new UsernamePasswordAuthenticationToken(email, senha, new ArrayList<>());
            }else{
                throw new BadCredentialsException("Credenciais Invalidas!");
            }
        }else {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
