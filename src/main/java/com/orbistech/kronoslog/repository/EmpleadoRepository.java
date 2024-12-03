package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByRolNombreRol(String nombreRol);
    List<Empleado> findByEstadoNombreEstado(String nombreEstado);
    Optional<Empleado> findByNombres(String nombres);
    Optional<Empleado> findByApellidos(String apellidos);
    Optional<Empleado> findByDni(String dni);
    Optional<Empleado> findByCodigoEmpleado(String codigoEmpleado);
    List<Empleado> findByArea(String area);
}
