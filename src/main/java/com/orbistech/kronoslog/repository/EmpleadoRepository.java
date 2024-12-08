package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Empleado;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>, JpaSpecificationExecutor<Empleado> {

    @Query("SELECT e FROM Empleado e JOIN FETCH e.estado JOIN FETCH e.horario WHERE e.id = :id")
    Optional<Empleado> findByIdWithEstadoAndHorario(@Param("id") long id);

    List<Empleado> findByRolNombreRol(String nombreRol);
    List<Empleado> findByEstadoNombreEstado(String nombreEstado);
    List<Empleado> findByNombres(String nombres);
    List<Empleado> findByApellidos(String apellidos);
    Optional<Empleado> findByDni(String dni);
    Optional<Empleado> findByCodigoEmpleado(String codigoEmpleado);
    List<Empleado> findByArea(String area);

    // Nuevo método para filtros combinados y paginación
    Page<Empleado> findAll(Specification<Empleado> spec, Pageable pageable);
}