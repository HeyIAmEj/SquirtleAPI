package br.com.squirtle.dto.model;

import br.com.squirtle.model.Dispositivo;
import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

        private Long id;

        private String nome;
        private String sobrenome;

        private String email;
        private String senha;

        private List<Dispositivo> dispositivos;
}
