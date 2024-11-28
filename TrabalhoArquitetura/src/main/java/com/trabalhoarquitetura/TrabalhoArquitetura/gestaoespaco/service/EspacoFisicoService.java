package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.service;

import com.trabalhoarquitetura.TrabalhoArquitetura.auditoriaConnection.Auditoria;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.repository.EspacoFisicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EspacoFisicoService {

   private final RestTemplate restTemplate;

   private final Auditoria auditoria;
   private final EspacoFisicoRepository espacoFisicoRepository;

    public EspacoFisicoService(final RestTemplate restTemplate, Auditoria auditoria, EspacoFisicoRepository espacoFisicoRepository) {
        this.restTemplate = restTemplate;
        this.auditoria = auditoria;
        this.espacoFisicoRepository = espacoFisicoRepository;
    }

    public EspacoFisicoEntity findById(Long id) {
        return espacoFisicoRepository.findById(id).get();
    }

    public EspacoFisicoEntity cadastrarEspaco(EspacoFisicoEntity espacoFisicoEntity) {
        espacoFisicoEntity =espacoFisicoRepository.save(espacoFisicoEntity);
        auditoria.enviarAuditoria("EspacoFisico", "cadastrarEspaco", espacoFisicoEntity.getIdEspaco());
        return espacoFisicoEntity;
    }

    public EspacoFisicoEntity editarEspaco(EspacoFisicoEntity espacoFisicoEntity) {
        espacoFisicoEntity = espacoFisicoRepository.save(espacoFisicoEntity);
        auditoria.enviarAuditoria("EspacoFisico", "editarEspaco", espacoFisicoEntity.getIdEspaco());
        return espacoFisicoEntity;
    }

    public EspacoFisicoEntity cadastrarRecurso(EspacoFisicoEntity espacoFisicoEntity) {
        espacoFisicoEntity = espacoFisicoRepository.save(espacoFisicoEntity);
        auditoria.enviarAuditoria("EspacoFisico", "cadastrarRecurso", espacoFisicoEntity.getIdEspaco());
        return espacoFisicoEntity;
    }
}
