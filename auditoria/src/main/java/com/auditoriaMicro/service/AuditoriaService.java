package com.auditoriaMicro.service;

import com.auditoriaMicro.entity.Auditoria;
import com.auditoriaMicro.repository.AuditoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService {

    private final AuditoriaRepository auditoriaRepository;

    public AuditoriaService(AuditoriaRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    public void save(Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
    }

    public List<Auditoria> findAll() {
        return auditoriaRepository.findAll();
    }

    public List<Auditoria> findByModulo(String modulo) {
        return auditoriaRepository.findByModulo(modulo);
    }
}
