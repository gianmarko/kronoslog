package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Sueldo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SueldoRepository extends JpaRepository<Sueldo, Long> {
    Optional<Sueldo> findByEmpleadoId(Long empleadoId);
}
