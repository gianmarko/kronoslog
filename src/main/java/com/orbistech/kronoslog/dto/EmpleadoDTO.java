package com.orbistech.kronoslog.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {
    private long id;
    private String nombres;
    private String apellidos;
    private String estadoNombre;
    private String horarioDescripcion;
}