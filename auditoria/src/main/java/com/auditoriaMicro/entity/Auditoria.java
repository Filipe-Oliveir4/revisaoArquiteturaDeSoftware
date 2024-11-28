package com.auditoriaMicro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String modulo;

    String acao;

    Long idObjeto;

    LocalDateTime dataHora;

    @PrePersist
    void defaultValue() {
        dataHora = LocalDateTime.now();
    }
}
