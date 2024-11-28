package com.trabalhoarquitetura.TrabalhoArquitetura.aprovacoes.entity;

import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.entity.SolicitacaoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico")
//lombok
@NoArgsConstructor
@Getter
@Setter
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;
    @OneToOne
    private SolicitacaoEntity solicitacaoEntity;
    private LocalDateTime dataAprovacao;
    private Boolean statusSolicitacao;
    private String observacao;

    public HistoricoEntity(SolicitacaoEntity solicitacaoEntity, LocalDateTime dataAprovacao, Boolean statusSolicitacao, String observacao) {
        this.solicitacaoEntity = solicitacaoEntity;
        this.dataAprovacao = dataAprovacao;
        this.statusSolicitacao = statusSolicitacao;
        this.observacao = observacao;
    }
}
