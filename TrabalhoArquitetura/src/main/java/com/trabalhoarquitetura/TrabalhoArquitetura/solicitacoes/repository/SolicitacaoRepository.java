package com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.repository;

import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.entity.SolicitacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<SolicitacaoEntity,Long> {

    @Query("SELECT e FROM SolicitacaoEntity e WHERE e.canceladoEm IS NULL AND e.status is NULL")
    List<SolicitacaoEntity> solicitacoesPendentes();

    @Query("SELECT e FROM SolicitacaoEntity e WHERE e.canceladoEm IS NULL AND e.status = true")
    List<SolicitacaoEntity> solicitacoesAprovadas();

    @Query("SELECT e FROM SolicitacaoEntity e WHERE e.canceladoEm IS NULL AND e.status = false")
    List<SolicitacaoEntity> solicitacoesRejeitadas();

    @Query("SELECT se FROM SolicitacaoEntity se join HistoricoEntity he on se.idSolicitacoes = he.solicitacaoEntity.idSolicitacoes WHERE se.espacoFisicoEntity = :espacoFisico AND ((se.inicio BETWEEN :inicio AND :fim) OR (se.fim BETWEEN :inicio AND :fim))")
    SolicitacaoEntity verificarConflitos(LocalDateTime inicio, LocalDateTime fim, EspacoFisicoEntity espacoFisico);
}
