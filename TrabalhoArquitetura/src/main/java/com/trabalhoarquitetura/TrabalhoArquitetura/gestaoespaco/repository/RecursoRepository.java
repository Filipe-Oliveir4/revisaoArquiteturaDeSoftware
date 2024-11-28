package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.repository;

import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecursoRepository extends JpaRepository<RecursoEntity,Long> {

    @Query("SELECT e FROM RecursoEntity e join EspacoFisicoEntity ef on e.espacoFisicoEntity = ef WHERE e.nome= (:nome) and e.espacoFisicoEntity = (:espacoFisicoEntity)")
    public RecursoEntity findByNome(String nome, EspacoFisicoEntity espacoFisicoEntity);
}
