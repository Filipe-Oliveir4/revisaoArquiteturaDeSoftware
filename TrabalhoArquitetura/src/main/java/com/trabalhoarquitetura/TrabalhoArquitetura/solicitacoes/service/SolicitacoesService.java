package com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.service;

import com.trabalhoarquitetura.TrabalhoArquitetura.aprovacoes.entity.HistoricoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.aprovacoes.repository.HistoricoRepository;
import com.trabalhoarquitetura.TrabalhoArquitetura.auditoriaConnection.Auditoria;
import com.trabalhoarquitetura.TrabalhoArquitetura.auditoriaConnection.AuditoriaDTO;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.entity.SolicitacaoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class SolicitacoesService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @Autowired
    HistoricoRepository historicoRepository;
    private final RestTemplate restTemplate;
    private final Auditoria auditoria;

    public SolicitacoesService(RestTemplate restTemplate, Auditoria auditoria) {
        this.restTemplate = restTemplate;
        this.auditoria = auditoria;
    }

    public SolicitacaoEntity cadastrarSolicitacao(SolicitacaoEntity solicitacaoEntity) throws Exception {
        if (solicitacaoEntity.getInicio().isAfter(solicitacaoEntity.getFim())) {
            throw new Exception("Data de início não pode ser posterior a data de fim");
        }
        solicitacaoEntity.setDataSolicitacao(LocalDateTime.now());
        solicitacaoEntity = solicitacaoRepository.save(solicitacaoEntity);
        auditoria.enviarAuditoria("EspacoFisico", "cadastrarSolicitacao", solicitacaoEntity.getIdSolicitacoes());
        return solicitacaoEntity;
    }

    public SolicitacaoEntity findById(Long id) {
        return solicitacaoRepository.findById(id).get();
    }

    public List<SolicitacaoEntity> listarSolicitacoes() {
        restTemplate.postForEntity("http://auditoria/auditoria",
                AuditoriaDTO.builder()
                        .modulo("EspacoFisico")
                        .acao("findById")
                        .build(),
                void.class
        );
        return solicitacaoRepository.findAll();
    }

    public SolicitacaoEntity cancelarSolicitacao(Long id) throws Exception {
        SolicitacaoEntity solicitacaoEntity = solicitacaoRepository.findById(id).get();
        if (solicitacaoEntity != null) {
            if (solicitacaoEntity.getCanceladoEm() != null) {
                throw new Exception("Solicitação já cancelada");
            }
            solicitacaoEntity.setCanceladoEm(LocalDateTime.now());
            solicitacaoEntity = solicitacaoRepository.save(solicitacaoEntity);
            auditoria.enviarAuditoria("EspacoFisico", "cancelarSolicitacao", solicitacaoEntity.getIdSolicitacoes());
        } else {
            throw new Exception("Solicitação não encontrada");
        }
        return solicitacaoEntity;

    }

    public SolicitacaoEntity editarSolicitacao(SolicitacaoEntity solicitacaoEntity)throws Exception {

            SolicitacaoEntity antiga = solicitacaoRepository.findById(solicitacaoEntity.getIdSolicitacoes()).get();
            if (antiga.getCanceladoEm() != null) {
                throw new Exception("Solicitação cancelada, não é possível editar");
            }
            if (!antiga.getUser().getIdUsuario().equals(solicitacaoEntity.getUser().getIdUsuario())) {
                throw new Exception("Usuário não pode editar solicitação de outro usuário");
            }
            solicitacaoEntity = solicitacaoRepository.save(solicitacaoEntity);
            auditoria.enviarAuditoria("EspacoFisico", "editarSolicitacao", solicitacaoEntity.getIdSolicitacoes());
            return solicitacaoEntity;

    }

    public List<SolicitacaoEntity> solicitacoesPendentes() {
        return solicitacaoRepository.solicitacoesPendentes();
    }

    public List<SolicitacaoEntity> solicitacoesAprovadas() {
        return solicitacaoRepository.solicitacoesAprovadas();
    }

    public List<SolicitacaoEntity> solicitacoesRejeitadas() {
        return solicitacaoRepository.solicitacoesRejeitadas();
    }

    public SolicitacaoEntity resolverSolicitacao(SolicitacaoEntity solicitacaoEntity, String observacao) throws Exception {
        if (solicitacaoEntity.getCanceladoEm() != null) {
            throw new Exception("Solicitação cancelada, não é possível resolver");
        }
        SolicitacaoEntity existeSolicitacao = solicitacaoRepository.verificarConflitos(solicitacaoEntity.getInicio(), solicitacaoEntity.getFim(), solicitacaoEntity.getEspacoFisicoEntity());
        if (existeSolicitacao != null) {
            throw new Exception("Conflito com outra solicitação");
        }
        solicitacaoEntity = solicitacaoRepository.save(solicitacaoEntity);
        auditoria.enviarAuditoria("EspacoFisico", "resolverSolicitacao",solicitacaoEntity.getIdSolicitacoes());
        historicoRepository.save(new HistoricoEntity(solicitacaoEntity, LocalDateTime.now(), solicitacaoEntity.getStatus(), observacao));
        return solicitacaoEntity;

    }
}
