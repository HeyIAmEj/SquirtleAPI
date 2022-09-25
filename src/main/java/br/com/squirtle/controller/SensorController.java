package br.com.squirtle.controller;

import br.com.squirtle.dto.DispositivoMapper;
import br.com.squirtle.dto.model.DispositivoDTO;
import br.com.squirtle.exception.DispositivoNaoEncontradoException;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/dispositivo", produces = MediaType.APPLICATION_JSON_VALUE)
public class SensorController {

    @Autowired
    private DispositivoService dispositivoService;

    private DispositivoMapper dispositivoMapper = DispositivoMapper.INSTANCE;

    @GetMapping("/{device_id}/sensor/{sensor_id}")
    public String valorSensor(@PathVariable Long device_id, @PathVariable Long sensor_id){
        String sensorValue = dispositivoService.getSensor(device_id, sensor_id);
        if(sensorValue == null){
            sensorValue = "";
        }
        return sensorValue;
    }

    @PutMapping("/{device_id}/sensor/{sensor_id}")
    public DispositivoDTO alterarSensor(@PathVariable Long device_id, @PathVariable Long sensor_id, @RequestBody DispositivoDTO dispositivoDTO) throws DispositivoNaoEncontradoException {
        Dispositivo dispositivo = new Dispositivo();
        String sensor_value;
        switch (sensor_id.toString()){
            case "1":
                sensor_value = dispositivoDTO.getSensor1();
                dispositivoDTO = dispositivoService.getDeviceById(device_id);
                dispositivoDTO.setSensor1(sensor_value);
                dispositivo = dispositivoMapper.toModel(dispositivoDTO);
                break;
            case "2":
                sensor_value = dispositivoDTO.getSensor2();
                dispositivoDTO = dispositivoService.getDeviceById(device_id);
                dispositivoDTO.setSensor2(sensor_value);
                dispositivo = dispositivoMapper.toModel(dispositivoDTO);
                break;
            case "3":
                sensor_value = dispositivoDTO.getSensor3();
                dispositivoDTO = dispositivoService.getDeviceById(device_id);
                dispositivoDTO.setSensor3(sensor_value);
                dispositivo = dispositivoMapper.toModel(dispositivoDTO);
                break;
            case "4":
                sensor_value = dispositivoDTO.getSensor4();
                dispositivoDTO = dispositivoService.getDeviceById(device_id);
                dispositivoDTO.setSensor4(sensor_value);
                dispositivo = dispositivoMapper.toModel(dispositivoDTO);
                break;
            case "5":
                sensor_value = dispositivoDTO.getSensor5();
                dispositivoDTO = dispositivoService.getDeviceById(device_id);
                dispositivoDTO.setSensor5(sensor_value);
                dispositivo = dispositivoMapper.toModel(dispositivoDTO);
                break;
        }
        return dispositivoService.updateSensor(dispositivo);
    }

}
