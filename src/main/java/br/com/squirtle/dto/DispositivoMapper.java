package br.com.squirtle.dto;

import br.com.squirtle.dto.model.DispositivoDTO;
import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DispositivoMapper {

    DispositivoMapper INSTANCE = Mappers.getMapper(DispositivoMapper.class);

    Dispositivo toModel(DispositivoDTO dispositivoDTO);

    DispositivoDTO toDTO(Dispositivo dispositivo);

}