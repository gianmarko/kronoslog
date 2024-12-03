package com.orbistech.kronoslog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private long id;

    @Column(name="nombre", nullable = false, unique = true)
    private String nombreRol;

    @Column(name="descripcion")
    private String descripcionRol;
}
