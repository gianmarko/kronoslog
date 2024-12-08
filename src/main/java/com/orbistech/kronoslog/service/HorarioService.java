package com.orbistech.kronoslog.service;

import com.orbistech.kronoslog.model.Estado;
import com.orbistech.kronoslog.model.Horario;
import com.orbistech.kronoslog.repository.EstadoRepository;
import com.orbistech.kronoslog.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository horarioRepository;
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

}


