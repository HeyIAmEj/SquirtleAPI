package br.com.squirtle.service;

import br.com.squirtle.dto.UsuarioMapper;
import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.exception.UsuarioNaoEncontradoException;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import br.com.squirtle.model.UsuarioDispositivo;
import br.com.squirtle.repository.LinkRepository;
import br.com.squirtle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LinkRepository linkRepository;

    private UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    public List<UsuarioDTO> getAllUsers() {
        List<Usuario> allUsers = usuarioRepository.findAll();
        return allUsers
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUserById(Long user_id) throws UsuarioNaoEncontradoException {
        Usuario usuario = usuarioRepository.findById(user_id).orElseThrow(() -> new UsuarioNaoEncontradoException(user_id));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO createUser(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);

    }

    // LINK CONTROLLER
    public Boolean linkUserDevice(Long user_id, Long device_id){
        if(usuarioRepository.existsById(user_id)){
            UsuarioDispositivo usuarioDispositivo = new UsuarioDispositivo();
            usuarioDispositivo.setUsuario_id(user_id);
            usuarioDispositivo.setDispositivo_id(device_id);
            linkRepository.save(usuarioDispositivo);
            return true;
        }
        return false;
    }

}
