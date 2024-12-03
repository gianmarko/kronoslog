package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, Long> {
    Optional<Credencial> findByEmail(String email);
    Optional<Credencial> findByCodigoEmpleado(String codigoEmpleado);

    Optional<Credencial> findByEmpleadoId(long id);
}
