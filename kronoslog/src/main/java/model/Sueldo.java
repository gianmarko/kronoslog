package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sueldos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sueldo")
    private long id;

    @OneToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fi_contrato")
    private LocalDate fechaInicioContrato;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fi_actividades")
    private LocalDate fechaInicioActividades;

    @Column(name = "ciclo_inicio")
    private int cicloInicio;

    @Column(name = "ciclo_fin")
    private int cicloFin;

    @Column(name = "dia_pago")
    private int diaPago;

    @Column(name = "p_hora_regular")
    private double precioHoraRegular;

    @Column(name = "p_hora_extra")
    private double precioHoraExtra;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "ff_contrato")
    private LocalDate fechaFinContrato;
}
