package br.com.squirtle.controller;

import br.com.squirtle.dto.DispositivoMapper;
import br.com.squirtle.dto.model.DispositivoDTO;
import br.com.squirtle.exception.DispositivoNaoEncontradoException;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PutMapping("/{device_id}/sensores")
    public HashMap<String, String> alterarSensoralterarSensores(@PathVariable Long device_id, @RequestBody DispositivoDTO dispositivoDTO) throws DispositivoNaoEncontradoException {
        DispositivoDTO deviceBD = dispositivoService.getDeviceById(device_id);

        String[] sensor_full = deviceBD.getSensor1().split(",");
        String s1_value = String.join(",", sensor_full[0], sensor_full[1], sensor_full[2], String.join(":", sensor_full[3].split(":")[0], dispositivoDTO.getSensor1()));

        sensor_full = deviceBD.getSensor2().split(",");
        String s2_value = String.join(",", sensor_full[0], sensor_full[1], sensor_full[2], String.join(":", sensor_full[3].split(":")[0], dispositivoDTO.getSensor2()));

        sensor_full = deviceBD.getSensor3().split(",");
        String s3_value = String.join(",", sensor_full[0], sensor_full[1], sensor_full[2], String.join(":", sensor_full[3].split(":")[0], dispositivoDTO.getSensor3()));

        sensor_full = deviceBD.getSensor4().split(",");
        String s4_value = String.join(",", sensor_full[0], sensor_full[1], sensor_full[2], String.join(":", sensor_full[3].split(":")[0], dispositivoDTO.getSensor4()));

        sensor_full = deviceBD.getSensor5().split(",");
        String s5_value = String.join(",", sensor_full[0], sensor_full[1], sensor_full[2], String.join(":", sensor_full[3].split(":")[0], dispositivoDTO.getSensor5()));


        deviceBD.setStatus(dispositivoDTO.getStatus());
        deviceBD.setSensor1(s1_value);
        deviceBD.setSensor2(s2_value);
        deviceBD.setSensor3(s3_value);
        deviceBD.setSensor4(s4_value);
        deviceBD.setSensor5(s5_value);

        Dispositivo deviceUpdated = dispositivoMapper.toModel(deviceBD);
        dispositivoService.updateSensor(deviceUpdated);

        HashMap<String, String> responsebody = new HashMap<>();
        responsebody.put("status", String.valueOf(HttpStatus.OK.value()));
        responsebody.put("success", "true");

        return responsebody;
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
