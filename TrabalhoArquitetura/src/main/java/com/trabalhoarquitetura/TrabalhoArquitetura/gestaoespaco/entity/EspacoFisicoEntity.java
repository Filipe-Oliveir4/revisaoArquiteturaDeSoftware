package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Entity
@Table(name = "espaco_fisico")
//lombok
@NoArgsConstructor
@Getter
@Setter
public class EspacoFisicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspaco;
    private String nome;
    private String capacidade;
    private String localizacao;
    @JsonManagedReference
    @OneToMany(mappedBy = "espacoFisicoEntity")
    private List<RecursoEntity> recursos;

}
