package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
