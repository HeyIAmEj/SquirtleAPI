package br.com.squirtle.dto;

import br.com.squirtle.dto.model.DispositivoDTO;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T13:42:19-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class DispositivoMapperImpl implements DispositivoMapper {

    @Override
    public Dispositivo toModel(DispositivoDTO dispositivoDTO) {
        if ( dispositivoDTO == null ) {
            return null;
        }

        Dispositivo dispositivo = new Dispositivo();

        dispositivo.setId( dispositivoDTO.getId() );
        dispositivo.setNome( dispositivoDTO.getNome() );
        dispositivo.setStatus( dispositivoDTO.getStatus() );
        dispositivo.setIcone( dispositivoDTO.getIcone() );
        dispositivo.setWifi_ssid( dispositivoDTO.getWifi_ssid() );
        dispositivo.setWifi_pass( dispositivoDTO.getWifi_pass() );
        dispositivo.setSensor1( dispositivoDTO.getSensor1() );
        dispositivo.setSensor2( dispositivoDTO.getSensor2() );
        dispositivo.setSensor3( dispositivoDTO.getSensor3() );
        dispositivo.setSensor4( dispositivoDTO.getSensor4() );
        dispositivo.setSensor5( dispositivoDTO.getSensor5() );
        List<Usuario> list = dispositivoDTO.getUsuarios();
        if ( list != null ) {
            dispositivo.setUsuarios( new ArrayList<Usuario>( list ) );
        }

        return dispositivo;
    }

    @Override
    public DispositivoDTO toDTO(Dispositivo dispositivo) {
        if ( dispositivo == null ) {
            return null;
        }

        DispositivoDTO.DispositivoDTOBuilder dispositivoDTO = DispositivoDTO.builder();

        dispositivoDTO.id( dispositivo.getId() );
        dispositivoDTO.nome( dispositivo.getNome() );
        dispositivoDTO.status( dispositivo.getStatus() );
        dispositivoDTO.icone( dispositivo.getIcone() );
        dispositivoDTO.wifi_ssid( dispositivo.getWifi_ssid() );
        dispositivoDTO.wifi_pass( dispositivo.getWifi_pass() );
        dispositivoDTO.sensor1( dispositivo.getSensor1() );
        dispositivoDTO.sensor2( dispositivo.getSensor2() );
        dispositivoDTO.sensor3( dispositivo.getSensor3() );
        dispositivoDTO.sensor4( dispositivo.getSensor4() );
        dispositivoDTO.sensor5( dispositivo.getSensor5() );
        List<Usuario> list = dispositivo.getUsuarios();
        if ( list != null ) {
            dispositivoDTO.usuarios( new ArrayList<Usuario>( list ) );
        }

        return dispositivoDTO.build();
    }
}
