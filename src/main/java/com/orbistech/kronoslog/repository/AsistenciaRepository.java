package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, String> {
    List<Asistencia> findByEmpleadoId(Long empleadoId);
    List<Asistencia> findByFechaAsistencia(LocalDate fechaAsistencia);
    List<Asistencia> findByAsistencias(boolean asistencias);
}
