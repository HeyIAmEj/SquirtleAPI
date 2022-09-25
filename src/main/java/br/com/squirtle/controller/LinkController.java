package br.com.squirtle.controller;

import br.com.squirtle.dto.UsuarioMapper;
import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.exception.UsuarioNaoEncontradoException;
import br.com.squirtle.repository.UsuarioRepository;
import br.com.squirtle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/link", produces = MediaType.APPLICATION_JSON_VALUE)
public class LinkController {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    @PostMapping("/{user_id}/{device_id}")
    public Boolean usuarioPorId(@PathVariable Long user_id, @PathVariable Long device_id){
        Boolean result = usuarioService.linkUserDevice(user_id, device_id);
        return result;
    }
}
