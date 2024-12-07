package com.orbistech.kronoslog.service;

import com.orbistech.kronoslog.model.Estado;
import com.orbistech.kronoslog.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;
    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }
}
