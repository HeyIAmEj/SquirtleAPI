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
    date = "2022-11-09T22:23:33-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
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
        dispositivo.setDescricao( dispositivoDTO.getDescricao() );
        dispositivo.setStatus( dispositivoDTO.getStatus() );
        dispositivo.setIcone( dispositivoDTO.getIcone() );
        dispositivo.setWifi_ssid( dispositivoDTO.getWifi_ssid() );
        dispositivo.setWifi_pass( dispositivoDTO.getWifi_pass() );
        dispositivo.setTipo_solo( dispositivoDTO.getTipo_solo() );
        dispositivo.setTempo_bomba( dispositivoDTO.getTempo_bomba() );
        dispositivo.setSensor1( dispositivoDTO.getSensor1() );
        dispositivo.setSensor2( dispositivoDTO.getSensor2() );
        dispositivo.setSensor3( dispositivoDTO.getSensor3() );
        dispositivo.setSensor4( dispositivoDTO.getSensor4() );
        dispositivo.setSensor5( dispositivoDTO.getSensor5() );
        dispositivo.setAction1( dispositivoDTO.getAction1() );
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
        dispositivoDTO.descricao( dispositivo.getDescricao() );
        dispositivoDTO.status( dispositivo.getStatus() );
        dispositivoDTO.icone( dispositivo.getIcone() );
        dispositivoDTO.wifi_ssid( dispositivo.getWifi_ssid() );
        dispositivoDTO.wifi_pass( dispositivo.getWifi_pass() );
        dispositivoDTO.tipo_solo( dispositivo.getTipo_solo() );
        dispositivoDTO.tempo_bomba( dispositivo.getTempo_bomba() );
        dispositivoDTO.sensor1( dispositivo.getSensor1() );
        dispositivoDTO.sensor2( dispositivo.getSensor2() );
        dispositivoDTO.sensor3( dispositivo.getSensor3() );
        dispositivoDTO.sensor4( dispositivo.getSensor4() );
        dispositivoDTO.sensor5( dispositivo.getSensor5() );
        dispositivoDTO.action1( dispositivo.getAction1() );
        List<Usuario> list = dispositivo.getUsuarios();
        if ( list != null ) {
            dispositivoDTO.usuarios( new ArrayList<Usuario>( list ) );
        }

        return dispositivoDTO.build();
    }
}
