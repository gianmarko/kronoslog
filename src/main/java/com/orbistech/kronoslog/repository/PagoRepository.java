package com.orbistech.kronoslog.repository;

import com.orbistech.kronoslog.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByEmpleadoId(Long empleadoId);
    List<Pago> findByFechaPagoRealizado(LocalDate fechaPagoRealizado);
}
