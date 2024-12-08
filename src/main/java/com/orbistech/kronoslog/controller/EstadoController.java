package com.orbistech.kronoslog.controller;

import com.orbistech.kronoslog.model.Estado;
import com.orbistech.kronoslog.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    //@PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping
    public ResponseEntity<List<Estado>> getEstados() {
        List<Estado> estados = estadoService.getAllEstados();
        return ResponseEntity.ok(estados);
    }
}
