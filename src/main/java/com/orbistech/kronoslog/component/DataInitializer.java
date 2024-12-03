package com.orbistech.kronoslog.component;

import com.orbistech.kronoslog.model.*;
import com.orbistech.kronoslog.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.IntStream;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CredencialRepository credencialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Crear roles
        createRole("Administrador");
        createRole("Usuario");

        // Crear estados
        createEstado("Activo");
        createEstado("Inactivo");
        createEstado("Bloqueado");

        // Crear horarios predeterminados
        createDefaultHorario("08:00:00", "17:00:00", "LUNES, MARTES, MIERCOLES, JUEVES, VIERNES");

        // Crear empleados
        IntStream.range(1, 31).forEach(this::createEmpleado);
    }

    private void createRole(String nombre) {
        rolRepository.findByNombreRol(nombre).orElseGet(() -> {
            Rol rol = new Rol();
            rol.setNombreRol(nombre);
            rol.setDescripcionRol("Rol predeterminado: " + nombre);
            return rolRepository.save(rol);
        });
    }

    private void createEstado(String nombre) {
        estadoRepository.findByNombreEstado(nombre).orElseGet(() -> {
            Estado estado = new Estado();
            estado.setNombreEstado(nombre);
            estado.setDescripcionEstado("Estado predeterminado: " + nombre);
            return estadoRepository.save(estado);
        });
    }

    private void createDefaultHorario(String horaInicio, String horaFin, String diasLaborales) {
        horarioRepository.findAll().stream()
                .filter(h -> h.getHoraInicio().toString().equals(horaInicio) && h.getHoraFin().toString().equals(horaFin))
                .findAny()
                .orElseGet(() -> {
                    Horario horario = new Horario();
                    horario.setHoraInicio(LocalTime.parse(horaInicio));
                    horario.setHoraFin(LocalTime.parse(horaFin));
                    horario.setDiasLaborales(diasLaborales);
                    return horarioRepository.save(horario);
                });
    }

    private void createEmpleado(int index) {
        String nombres = "Empleado" + index;
        String apellidos = "Apellido" + index;
        String dni = String.format("%08d", index);
        String codigoEmpleado = nombres.charAt(0) + String.valueOf(apellidos.charAt(0)) + dni;

        // Verificar si el empleado ya existe por DNI
        if (empleadoRepository.findByDni(dni).isPresent()) {
            return; // Si existe, no lo crea nuevamente
        }

        // Generar un número de celular único y válido (9 caracteres)
        String celular = String.format("98765%04d", index);

        Rol rol = (index % 2 == 0) ? rolRepository.findByNombreRol("Administrador").orElseThrow() : rolRepository.findByNombreRol("Usuario").orElseThrow();
        Estado estado = switch (index % 3) {
            case 0 -> estadoRepository.findByNombreEstado("Activo").orElseThrow();
            case 1 -> estadoRepository.findByNombreEstado("Inactivo").orElseThrow();
            default -> estadoRepository.findByNombreEstado("Bloqueado").orElseThrow();
        };

        Horario horario = horarioRepository.findAll().get(0);

        // Crear el empleado
        Empleado empleado = new Empleado();
        empleado.setNombres(nombres);
        empleado.setApellidos(apellidos);
        empleado.setDni(dni);
        empleado.setCodigoEmpleado(codigoEmpleado);
        empleado.setEmail(codigoEmpleado.toLowerCase() + "@empresa.com");
        empleado.setCelular(celular); // Número de celular válido
        empleado.setDireccion("Dirección " + index);
        empleado.setCargo((index % 2 == 0) ? "Gerente" : "Asistente");
        empleado.setArea((index % 2 == 0) ? "Administración" : "Operaciones");
        empleado.setRol(rol);
        empleado.setEstado(estado);
        empleado.setHorario(horario);
        empleado.setFechaRegistro(LocalDateTime.now());
        empleado.setFechaModificacion(LocalDateTime.now());

        empleadoRepository.save(empleado);

        createCredencial(empleado, codigoEmpleado, rol, estado);
    }

    private void createCredencial(Empleado empleado, String codigoEmpleado, Rol rol, Estado estado) {
        // Verificar si la credencial ya existe por empleado
        if (credencialRepository.findByEmpleadoId(empleado.getId()).isPresent()) {
            return; // Si existe, no la crea nuevamente
        }

        Credencial credencial = new Credencial();
        credencial.setEmpleado(empleado);
        credencial.setCodigoEmpleado(codigoEmpleado);
        credencial.setEmail(empleado.getEmail());
        credencial.setContrasenia(passwordEncoder.encode(codigoEmpleado + "$"));
        credencial.setFechaRegistro(LocalDateTime.now());
        credencial.setRol(rol);
        credencial.setEstado(estado);

        credencialRepository.save(credencial);
    }
}