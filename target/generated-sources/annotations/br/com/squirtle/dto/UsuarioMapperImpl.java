package br.com.squirtle.dto;

import br.com.squirtle.dto.model.UsuarioDTO;
import br.com.squirtle.model.Dispositivo;
import br.com.squirtle.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-25T17:25:37-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toModel(UsuarioDTO pessoaDTO) {
        if ( pessoaDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( pessoaDTO.getId() );
        usuario.setNome( pessoaDTO.getNome() );
        usuario.setSobrenome( pessoaDTO.getSobrenome() );
        usuario.setEmail( pessoaDTO.getEmail() );
        usuario.setSenha( pessoaDTO.getSenha() );
        List<Dispositivo> list = pessoaDTO.getDispositivos();
        if ( list != null ) {
            usuario.setDispositivos( new ArrayList<Dispositivo>( list ) );
        }

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.id( pessoa.getId() );
        usuarioDTO.nome( pessoa.getNome() );
        usuarioDTO.sobrenome( pessoa.getSobrenome() );
        usuarioDTO.email( pessoa.getEmail() );
        usuarioDTO.senha( pessoa.getSenha() );
        List<Dispositivo> list = pessoa.getDispositivos();
        if ( list != null ) {
            usuarioDTO.dispositivos( new ArrayList<Dispositivo>( list ) );
        }

        return usuarioDTO.build();
    }
}
