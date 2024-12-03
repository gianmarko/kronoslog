package com.orbistech.kronoslog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_pago_realizado", nullable = false)
    private LocalDate fechaPagoRealizado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sueldo", nullable = false)
    private Sueldo sueldo;

    @Column(name = "dia_pago")
    private int diaPago;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "periodo_inicio")
    private LocalDate periodoInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "periodo_fin")
    private LocalDate periodoFin;

    @Column(name = "monto_regular", nullable = false)
    private double montoRegular;

    @Column(name = "monto_extra")
    private double montoExtra;

    @Column(name = "monto_descuento")
    private double montoDescuento;

    @Column(name = "bono_merito")
    private boolean bonoMerito;

    @Column(name = "monto_justificacion")
    private double montoJustificacion;

    @Column(name = "monto_total", nullable = false)
    private double montoTotal;

    @Column(name = "observaciones")
    private String observaciones;
}
