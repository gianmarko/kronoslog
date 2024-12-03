package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "justificaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Justificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_justificacion")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_asistencia", nullable = false)
    private Asistencia asistencia;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_justificacion")
    private LocalDateTime fechaJustificacion;

    @Column(name = "motivo_justificacion")
    private String motivoJustificacion;

    @Column(name = "estado_justificacion", nullable = false)
    private String estadoJustificacion;

    @Column(name = "detalle_justificacion")
    private String detalleJustificacion;

    @Column(name = "responsable_justificacion")
    private String responsableJustificacion;

    @Column(name = "documento")
    private String documento;

    @Column(name = "observacion_justificacion")
    private String observacionJustificacion;

    @Column(name = "detalle_respuesta")
    private String detalleRespuesta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_respuesta")
    private LocalDateTime fechaRespuesta;
}
