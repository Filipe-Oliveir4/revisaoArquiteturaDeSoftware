package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table(name = "recursos")
//lombok
@NoArgsConstructor
@Getter
@Setter
public class RecursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecurso;
    @JsonBackReference
    @ManyToOne
    private EspacoFisicoEntity espacoFisicoEntity;
    private String nome;
}
