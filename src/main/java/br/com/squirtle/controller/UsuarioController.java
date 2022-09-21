package br.com.squirtle.controller;

import br.com.squirtle.model.Usuario;
import br.com.squirtle.service.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/v1/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{user_id}")
    public String index(@PathVariable Long user_id) throws JSONException {
        JSONObject obj = new JSONObject();
        usuarioService.setOneUser(1L);
        usuarioService.setOneUser(2L);
        Optional<Usuario> usuarioList = usuarioService.getUserById(user_id);
        if(usuarioList.isEmpty()){
            obj.put("status", HttpStatus.NO_CONTENT);
        }else{
            obj.put("status", HttpStatus.OK);
            obj.put("usuario", usuarioList.get());
        }
        return obj.toString();
    }
}
