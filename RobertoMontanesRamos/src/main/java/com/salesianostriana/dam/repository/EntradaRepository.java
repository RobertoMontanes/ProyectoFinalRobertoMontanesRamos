package com.salesianostriana.dam.repository;

import com.salesianostriana.dam.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    List<Entrada> findByVendidaFalse();
    List<Entrada> findByClienteId(Long clienteId);
}