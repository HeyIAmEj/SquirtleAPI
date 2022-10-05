package br.com.squirtle.controller;

import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiIndexController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/api/v1/")
    public String indexapi() {
        return "helloapi";
    }

    @GetMapping("/api/v1/usuariosecret")
    public List<UsuarioDTO> usuarios(){
        return usuarioService.getAllUsers();
    }


}
