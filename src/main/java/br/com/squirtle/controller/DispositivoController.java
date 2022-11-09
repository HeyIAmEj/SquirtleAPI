package br.com.squirtle.controller;

import br.com.squirtle.dto.DispositivoMapper;
import br.com.squirtle.dto.model.DispositivoDTO;
import br.com.squirtle.exception.DispositivoNaoEncontradoException;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import br.com.squirtle.repository.DispositivoRepository;
import br.com.squirtle.security.JWTUtils;
import br.com.squirtle.service.DispositivoService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/dispositivo", produces = MediaType.APPLICATION_JSON_VALUE)
public class DispositivoController {
    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private DispositivoService dispositivoService;

    private DispositivoMapper dispositivoMapper = DispositivoMapper.INSTANCE;


    @GetMapping()
    public List<DispositivoDTO> dispositivos(){
        return dispositivoService.getAllDevices();
    }

    @GetMapping("/{device_id}")
    public DispositivoDTO dispositivoPorId(@PathVariable Long device_id) throws DispositivoNaoEncontradoException {
        DispositivoDTO dispositivoDTO = dispositivoService.getDeviceById(device_id);
        return dispositivoDTO;
    }

    @PostMapping()
    public DispositivoDTO criarDispositivo(@RequestHeader HttpHeaders httpHeaders, @RequestBody DispositivoDTO dispositivoDTO){
        String jwtAuthorizationHeader = String.valueOf(httpHeaders.getFirst(HttpHeaders.AUTHORIZATION));
        String jwt = jwtAuthorizationHeader.substring(7);
        String user_id = jwtUtils.getIdFromToken(jwt);
        return dispositivoService.createDevice(dispositivoDTO, user_id);
    }

    @PutMapping()
    public DispositivoDTO atualizarDispositivo(@RequestHeader HttpHeaders httpHeaders, @RequestBody DispositivoDTO dispositivoDTO){
        String jwtAuthorizationHeader = String.valueOf(httpHeaders.getFirst(HttpHeaders.AUTHORIZATION));
        String jwt = jwtAuthorizationHeader.substring(7);
        return dispositivoService.updateDevice(dispositivoDTO);
    }

    @DeleteMapping()
    public boolean deletarDispositivo(@RequestHeader HttpHeaders httpHeaders, @RequestBody DispositivoDTO dispositivoDTO){
        String jwtAuthorizationHeader = String.valueOf(httpHeaders.getFirst(HttpHeaders.AUTHORIZATION));
        String jwt = jwtAuthorizationHeader.substring(7);
        String user_id = jwtUtils.getIdFromToken(jwt);
        return dispositivoService.removeDevice(dispositivoDTO, user_id);
    }

}
