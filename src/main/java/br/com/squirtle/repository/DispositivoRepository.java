package br.com.squirtle.repository;


import br.com.squirtle.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    @Query("SELECT device.sensor1 FROM Dispositivo device WHERE device.id = :device_id")
    String getSensor1(Long device_id);

    @Query("SELECT device.sensor2 FROM Dispositivo device WHERE device.id = :device_id")
    String getSensor2(Long device_id);

    @Query("SELECT device.sensor3 FROM Dispositivo device WHERE device.id = :device_id")
    String getSensor3(Long device_id);

    @Query("SELECT device.sensor4 FROM Dispositivo device WHERE device.id = :device_id")
    String getSensor4(Long device_id);

    @Query("SELECT device.sensor5 FROM Dispositivo device WHERE device.id = :device_id")
    String getSensor5(Long device_id);

}
