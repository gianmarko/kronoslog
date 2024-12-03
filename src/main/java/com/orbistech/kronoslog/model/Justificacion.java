package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "justificaciones")
@Getter
@Setter
@NoArgsConstructor
public class Justificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_justificacion")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asistencia", nullable = false)
    private Asistencia asistencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_justificacion",nullable = false)
    private LocalDateTime fechaJustificacion;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "documento")
    private String documento;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "detalle_respuesta")
    private String detalleRespuesta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;
}
