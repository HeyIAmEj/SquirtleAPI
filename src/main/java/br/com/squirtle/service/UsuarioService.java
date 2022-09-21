package br.com.squirtle.service;

import br.com.squirtle.model.Usuario;
import br.com.squirtle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Optional<Usuario> getUserById(Long user_id){
        return usuarioRepository.findById(user_id);
    }

    public Optional<Usuario> setOneUser(Long id){
        Usuario usuario = new Usuario(id, "Teste", "teste@teste.com", "123");
        return Optional.of(usuarioRepository.save(usuario));
    }

}
