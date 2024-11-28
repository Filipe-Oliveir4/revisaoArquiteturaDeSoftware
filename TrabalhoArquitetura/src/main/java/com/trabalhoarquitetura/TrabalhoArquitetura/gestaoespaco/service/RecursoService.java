package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.service;

import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.RecursoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoService {

    @Autowired
    RecursoRepository recursoRepository;

    public RecursoEntity findById(Long id) {
        return recursoRepository.findById(id).get();
    }
}
