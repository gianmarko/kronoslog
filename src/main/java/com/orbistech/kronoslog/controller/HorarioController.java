package com.orbistech.kronoslog.controller;

import com.orbistech.kronoslog.model.Horario;
import com.orbistech.kronoslog.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/horarios")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    //@PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping
    public ResponseEntity<List<Horario>> getHorarios() {
        List<Horario> horarios = horarioService.getAllHorarios();
        return ResponseEntity.ok(horarios);
    }
}
