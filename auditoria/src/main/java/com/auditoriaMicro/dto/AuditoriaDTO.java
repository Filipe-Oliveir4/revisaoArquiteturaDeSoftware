package com.auditoriaMicro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AuditoriaDTO {

    Long id;

    String modulo;

    String acao;

    Long idObjeto;

    LocalDateTime dataHora;
}
