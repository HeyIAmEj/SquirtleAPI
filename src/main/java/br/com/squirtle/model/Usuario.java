package br.com.squirtle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sobrenome;

    @Column(unique=true)
    private String email;

    @JsonIgnore
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "UsuarioDispositivo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositivo_id"))
    private List<Dispositivo> dispositivos;

}
