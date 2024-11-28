package com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "solicitacoes")
//lombok
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SolicitacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitacoes;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private EspacoFisicoEntity espacoFisicoEntity;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataSolicitacao;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime inicio;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fim;
    private Boolean status;
    private String necessidadesEspecificas;
    private LocalDateTime canceladoEm;
    private LocalDateTime editadoEm;

}
