package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDto {
    Long idRecurso;
    String nome;
}
