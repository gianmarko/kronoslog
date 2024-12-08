package com.orbistech.kronoslog.service;

import com.orbistech.kronoslog.dto.EmpleadoDTO;
import com.orbistech.kronoslog.model.*;
import com.orbistech.kronoslog.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CredencialRepository credencialRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<EmpleadoDTO> getAllEmpleados() {
        return empleadoRepository.findAll().stream().map(Empleado::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public EmpleadoDTO getEmpleadoById(long id) {
        Empleado empleado = empleadoRepository.findByIdWithEstadoAndHorario(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        return empleado.toDTO();
    }

    public Page<EmpleadoDTO> getEmpleadosFiltered(String rol, String estado, String area, Pageable pageable) {
        Specification<Empleado> spec = Specification.where(null);

        if (rol != null && !rol.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("rol").get("nombreRol"), rol));
        }
        if (estado != null && !estado.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("estado").get("nombreEstado"), estado));
        }
        if (area != null && !area.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("area"), area));
        }

        return empleadoRepository.findAll(spec, pageable).map(Empleado::toDTO);
    }

    @Transactional
    public Empleado registerEmpleado(Empleado empleado) {
        // Validar existencia de DNI
        if (empleadoRepository.findByDni(empleado.getDni()).isPresent()) {
            throw new RuntimeException("Ya existe un empleado con el mismo DNI");
        }

        // Generar código de empleado
        String codigoEmpleado = empleado.getNombres().substring(0, 1).toLowerCase() +
                empleado.getApellidos().substring(0, 1).toLowerCase() +
                empleado.getDni();
        empleado.setCodigoEmpleado(codigoEmpleado);

        // Validar existencia de código de empleado
        if (empleadoRepository.findByCodigoEmpleado(codigoEmpleado).isPresent()) {
            throw new RuntimeException("El código de empleado ya existe");
        }

        // Guardar empleado
        empleado.setFechaRegistro(LocalDateTime.now());
        empleado.setFechaModificacion(LocalDateTime.now());
        Empleado savedEmpleado = empleadoRepository.save(empleado);

        // Crear credencial
        String contrasenia = codigoEmpleado + "$";
        Credencial credencial = new Credencial();
        credencial.setEmpleado(savedEmpleado);
        credencial.setCodigoEmpleado(codigoEmpleado);
        credencial.setContrasenia(passwordEncoder.encode(contrasenia));
        credencial.setEmail(empleado.getEmail());
        credencial.setFechaRegistro(LocalDateTime.now());
        credencial.setFechaModificacion(LocalDateTime.now());

        credencialRepository.save(credencial);

        return savedEmpleado;
    }
}
