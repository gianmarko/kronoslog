package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    private String dni;

    @Column(name = "codigo_empleado", nullable = false, unique = true, length = 10)
    private String codigoEmpleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "f_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "celular", nullable = false, unique = true, length = 9)
    private String celular;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "area")
    private String area;

    @Column(name = "responsable")
    private String responsable;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_registro")
    private LocalDateTime fechaRegistro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "f_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;
}
