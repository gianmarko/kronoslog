package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "evaluaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    @Column(name = "puntaje")
    private double puntaje;

    @Column(name = "evaluador")
    private String evaluador;

    @Column(name = "obs_evaluacion")
    private String observacionesEvaluacion;
}
