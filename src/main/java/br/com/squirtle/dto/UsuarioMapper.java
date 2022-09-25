package br.com.squirtle.dto;

import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.model.Usuario;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toModel(UsuarioDTO pessoaDTO);

    UsuarioDTO toDTO(Usuario pessoa);

}