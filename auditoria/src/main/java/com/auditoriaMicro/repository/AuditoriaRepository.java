package com.auditoriaMicro.repository;

import com.auditoriaMicro.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByModulo(String modulo);
}
