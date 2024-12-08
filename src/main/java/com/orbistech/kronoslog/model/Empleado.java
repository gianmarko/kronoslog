package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbistech.kronoslog.dto.EmpleadoDTO;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id;

    @NotNull
    @Column(name = "nombres", nullable = false)
    private String nombres;

    @NotNull
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @NotNull
    @Size(min = 8, max = 8)
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @NotNull
    @Size(max = 10)
    @Column(name = "codigo_empleado", nullable = false, unique = true)
    private String codigoEmpleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 9, max = 9)
    @Column(name = "celular", nullable = false, unique = true)
    private String celular;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "area")
    private String area;

    @Column(name = "responsable")
    private String responsable;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    public EmpleadoDTO toDTO() {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(this.id);
        dto.setNombres(this.nombres);
        dto.setApellidos(this.apellidos);
        dto.setEstadoNombre(this.estado != null ? this.estado.getNombreEstado() : null);
        dto.setHorarioDescripcion(this.horario != null ? this.horario.getDiasLaborales() : null);
        return dto;
    }
}