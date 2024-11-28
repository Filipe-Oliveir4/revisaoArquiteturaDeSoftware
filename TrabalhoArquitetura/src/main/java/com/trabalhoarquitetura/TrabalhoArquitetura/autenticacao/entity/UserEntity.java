package com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
//lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 20, nullable = false)
    private String username;
    @JsonIgnore
    @Column(length = 100, nullable = false)
    private String password;
    private String role;

}