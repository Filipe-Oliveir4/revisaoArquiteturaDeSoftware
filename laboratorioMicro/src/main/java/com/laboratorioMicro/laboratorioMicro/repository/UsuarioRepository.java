package com.laboratorioMicro.laboratorioMicro.repository;

import com.laboratorioMicro.laboratorioMicro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("select U from Usuario U where U.login = :login")
    Usuario getUsuarioPeloLogin(@Param("login") String login);
}
