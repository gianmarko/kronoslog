package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencias")
@Getter
@Setter
@NoArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_asistencia")
    private LocalDate fechaAsistencia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "registro_entrada")
    private LocalTime registroEntrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "registro_salida")
    private LocalTime registroSalida;

    @Column(name = "asistencias", nullable = false)
    private boolean asistencias;

    @Column(name = "tardanzas")
    private boolean tardanzas;

    @Column(name = "faltas")
    private boolean faltas;

    @Column(name = "horas_regulares")
    private int horasRegulares;

    @Column(name = "horas_extras")
    private int horasExtras;

    @Column(name = "horas_totales")
    private int horasTotales;
}
