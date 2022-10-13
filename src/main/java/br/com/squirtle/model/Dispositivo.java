package br.com.squirtle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @ManyToMany(mappedBy = "dispositivos")
    private List<Usuario> usuarios;
}
