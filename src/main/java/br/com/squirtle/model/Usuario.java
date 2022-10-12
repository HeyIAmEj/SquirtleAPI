package br.com.squirtle.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;

    private String email;
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "UsuarioDispositivo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositivo_id"))
    private List<Dispositivo> dispositivos;

}
