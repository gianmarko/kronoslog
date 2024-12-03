package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByEmpleadoId(Long empleadoId);
    List<Evaluacion> findByEvaluador(String evaluador);
}
