package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "horarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private long id;

    @ElementCollection(targetClass = Dia.class)
    @CollectionTable(name = "dias_laborales", joinColumns = @JoinColumn(name = "id_horario"))
    @Enumerated(EnumType.STRING)
    private Set<Dia> diasLaborales;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "h_inicio", nullable = false)
    private LocalTime horaInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "h_fin", nullable = false)
    private LocalTime horaFin;

    public enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
    }
}
