package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "horarios")
@Getter
@Setter
@NoArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private long id;

    @Column(name = "dias_laborales", nullable = false)
    private String diasLaborales;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    public enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
    }
}
