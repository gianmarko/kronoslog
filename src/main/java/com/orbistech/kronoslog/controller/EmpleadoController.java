package com.orbistech.kronoslog.controller;

import com.orbistech.kronoslog.dto.EmpleadoDTO;
import com.orbistech.kronoslog.model.Empleado;
import com.orbistech.kronoslog.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> getEmpleadoById(@PathVariable long id) {
        return ResponseEntity.ok(empleadoService.getEmpleadoById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<EmpleadoDTO>> getEmpleadosFiltered(
            @RequestParam(required = false) String rol,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String area,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<EmpleadoDTO> empleados = empleadoService.getEmpleadosFiltered(rol, estado, area, pageable);
        return ResponseEntity.ok(empleados);
    }

    @PostMapping
    public ResponseEntity<Empleado> registerEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoService.registerEmpleado(empleado);
        return ResponseEntity.ok(savedEmpleado);
    }
}