package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "credenciales")
@Getter
@Setter
@NoArgsConstructor
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @NotNull
    @Size(max = 10)
    @Column(name = "codigo_empleado", nullable = false, unique = true)
    private String codigoEmpleado;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "recuperacion_token")
    private String recuperacionToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_expiracion_token")
    private LocalDateTime fechaExpiracionToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_ultimo_logeo")
    private LocalDateTime fechaUltimoLogeo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_modificacion_contrasenia")
    private LocalDateTime fechaModificacionContrasenia;

    @Column(name = "intentos_fallidos")
    private int intentosFallidos;

    @Column(name = "responsable")
    private String responsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
