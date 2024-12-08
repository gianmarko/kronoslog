package com.orbistech.kronoslog.service;

import com.orbistech.kronoslog.model.Rol;
import com.orbistech.kronoslog.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public List<Rol> getAllRoles(){
        return rolRepository.findAll();
    }
}