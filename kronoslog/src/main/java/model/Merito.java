package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "meritos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_merito")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fi_periodo")
    private LocalDate fechaInicioPeriodo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "ff_periodo")
    private LocalDate fechaFinPeriodo;

    @Column(name = "posicion")
    private int posicion;

    @Column(name = "total_evaluados")
    private int totalEvaluados;
}
