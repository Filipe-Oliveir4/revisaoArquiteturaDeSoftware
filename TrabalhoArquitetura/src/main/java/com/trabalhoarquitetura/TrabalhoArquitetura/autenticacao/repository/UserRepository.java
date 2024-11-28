package com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.repository;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT e FROM UserEntity e WHERE e.username= (:username)")
    UserEntity findByUsername(@Param("username") String username);
}