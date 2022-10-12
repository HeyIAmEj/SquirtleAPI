package br.com.squirtle.service;

import br.com.squirtle.dto.DispositivoMapper;
import br.com.squirtle.dto.model.DispositivoDTO;
import br.com.squirtle.exception.DispositivoNaoEncontradoException;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import br.com.squirtle.model.UsuarioDispositivo;
import br.com.squirtle.repository.DispositivoRepository;
import br.com.squirtle.repository.LinkRepository;
import br.com.squirtle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DispositivoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LinkRepository usuarioDispositivoRepository;
    @Autowired
    private DispositivoRepository dispositivoRepository;

    private DispositivoMapper dispositivoMapper = DispositivoMapper.INSTANCE;

    public List<DispositivoDTO> getAllDevices() {
        List<Dispositivo> allDevices = dispositivoRepository.findAll();
        return allDevices
                .stream()
                .map(dispositivoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DispositivoDTO getDeviceById(Long device_id) throws DispositivoNaoEncontradoException {
        Dispositivo dispositivo = dispositivoRepository.findById(device_id).orElseThrow(() -> new DispositivoNaoEncontradoException(device_id));
        return dispositivoMapper.toDTO(dispositivo);
    }

    public DispositivoDTO updateSensor(Dispositivo dispositivo){
        return dispositivoMapper.toDTO(dispositivoRepository.save(dispositivo));

    }

    public String getSensor(Long device_id, Long sensor_id){
        String value = "";
        switch (sensor_id.toString()){
            case "1":
                value = dispositivoRepository.getSensor1(device_id);
                break;
            case "2":
                value = dispositivoRepository.getSensor2(device_id);
                break;
            case "3":
                value = dispositivoRepository.getSensor3(device_id);
                break;
            case "4":
                value = dispositivoRepository.getSensor4(device_id);
                break;
            case "5":
                value = dispositivoRepository.getSensor5(device_id);
                break;

        }
        return value;

    }
    public DispositivoDTO createDevice(DispositivoDTO dispositivoDTO, String user_id){

        Usuario usuario = usuarioRepository.findById(Long.valueOf(user_id)).orElseThrow();

        Dispositivo dispositivo = dispositivoMapper.toModel(dispositivoDTO);
        dispositivo = dispositivoRepository.save(dispositivo);

        UsuarioDispositivo usuarioDispositivo = new UsuarioDispositivo();
        usuarioDispositivo.setDispositivo_id(dispositivo.getId());
        usuarioDispositivo.setUsuario_id(usuario.getId());
        usuarioDispositivoRepository.save(usuarioDispositivo);

        return dispositivoMapper.toDTO(dispositivo);

    }

}
