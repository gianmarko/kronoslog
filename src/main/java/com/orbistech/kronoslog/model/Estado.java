package com.orbistech.kronoslog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados")
@Getter
@Setter
@NoArgsConstructor
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private long id;

    @Column(name="nombre", nullable = false, unique = true)
    private String nombreEstado;

    @Column(name="descripcion")
    private String descripcionEstado;
}