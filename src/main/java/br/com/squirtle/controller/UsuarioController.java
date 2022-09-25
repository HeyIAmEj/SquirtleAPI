package br.com.squirtle.controller;

import br.com.squirtle.dto.UsuarioMapper;
import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.exception.UsuarioNaoEncontradoException;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import br.com.squirtle.repository.DispositivoRepository;
import br.com.squirtle.repository.UsuarioRepository;
import br.com.squirtle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    private UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;


    @GetMapping()
    public List<UsuarioDTO> usuarios(){
        return usuarioService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public UsuarioDTO usuarioPorId(@PathVariable Long user_id) throws UsuarioNaoEncontradoException {
        UsuarioDTO usuarioDTO = usuarioService.getUserById(user_id);
        return usuarioDTO;
    }

    @PostMapping()
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.createUser(usuarioDTO);
    }


}
