package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "meritos")
@Getter
@Setter
@NoArgsConstructor
public class Merito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_merito")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_inicio_periodo", nullable = false)
    private LocalDate fechaInicioPeriodo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_fin_periodo", nullable = false)
    private LocalDate fechaFinPeriodo;

    @Column(name = "posicion", nullable = false)
    private int posicion;

    @Column(name = "total_evaluados", nullable = false)
    private int totalEvaluados;
}
