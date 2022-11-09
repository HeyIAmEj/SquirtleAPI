package br.com.squirtle.dto.model;

import br.com.squirtle.model.Usuario;
import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDTO {

    private Long id;

    private String nome;
    private String descricao;

    private Boolean status;

    private String icone;

    private String wifi_ssid;
    private String wifi_pass;

    private String tipo_solo;
    private String tempo_bomba;

    private String sensor1;
    private String sensor2;
    private String sensor3;
    private String sensor4;
    private String sensor5;

    private String action1;


    private List<Usuario> usuarios;
}
