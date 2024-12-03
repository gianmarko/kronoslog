package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "sueldos")
@Getter
@Setter
@NoArgsConstructor
public class Sueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sueldo")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_inicio_contrato", nullable = false)
    private LocalDate fechaInicioContrato;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_inicio_actividades", nullable = false)
    private LocalDate fechaInicioActividades;

    @Column(name = "ciclo_inicio")
    private int cicloInicio;

    @Column(name = "ciclo_fin")
    private int cicloFin;

    @Column(name = "dia_pago", nullable = false)
    private int diaPago;

    @Column(name = "precio_hora_regular")
    private double precioHoraRegular;

    @Column(name = "precio_hora_extra")
    private double precioHoraExtra;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_fin_contrato", nullable = false)
    private LocalDate fechaFinContrato;
}
