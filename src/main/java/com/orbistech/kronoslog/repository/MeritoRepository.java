package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Merito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeritoRepository extends JpaRepository<Merito, Long> {
    List<Merito> findByEmpleadoId(Long empleadoId);
}
