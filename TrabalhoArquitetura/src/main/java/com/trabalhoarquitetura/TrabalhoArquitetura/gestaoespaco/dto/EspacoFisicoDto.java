package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EspacoFisicoDto {
    Long idEspaco;
    String nome;
    String capacidade;
    String localizacao;
    List<RecursoDto> recursos;
}
