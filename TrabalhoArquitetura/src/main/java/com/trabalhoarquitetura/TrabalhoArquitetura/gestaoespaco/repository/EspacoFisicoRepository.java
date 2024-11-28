package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.repository;

import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EspacoFisicoRepository extends JpaRepository<EspacoFisicoEntity, Long> {
    @Query("SELECT e FROM EspacoFisicoEntity e WHERE e.nome= (:nome)")
    public EspacoFisicoEntity findByNome(String nome);
}
