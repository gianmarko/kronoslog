package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private long id;

    @Column(name="nombre", nullable = false)
    private String nombreEstado;

    @Column(name="descripcion")
    private String descripcionEstado;
}