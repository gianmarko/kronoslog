package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "solicitudes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;

    @Column(name = "estado_solicitud")
    private String estadoSolicitud;

    @Column(name = "responsable_solicitud")
    private String responsableSolicitud;

    @Column(name = "observacion_solicitud")
    private String observacionSolicitud;
}
