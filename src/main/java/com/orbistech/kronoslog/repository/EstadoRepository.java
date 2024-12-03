package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNombreEstado(String nombreEstado);
}
