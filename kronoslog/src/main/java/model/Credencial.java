package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "credenciales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private long id;

    @OneToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @Column(name = "codigo_empleado", nullable = false, unique = true, length = 10)
    private String codigoEmpledo;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "recuperacion_token")
    private String recuperacionToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_expiracion_token")
    private LocalDateTime fechaExpiracionToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_registro")
    private LocalDateTime fechaRegistro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_modificacion")
    private LocalDateTime fechaModificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_ultimo_logeo")
    private LocalDateTime fechaUltimoLogeo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_modificacion_contrasenia")
    private LocalDateTime fechaModificacionContrasenia;

    @Column(name = "intentos_fallidos")
    private int intentosFallidos;

    @Column(name = "responsable")
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
