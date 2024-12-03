package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Justificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JustificacionRepository extends JpaRepository<Justificacion, Long> {
    List<Justificacion> findByEmpleadoId(Long empleadoId);
    List<Justificacion> findByEstado(String estado);
}
