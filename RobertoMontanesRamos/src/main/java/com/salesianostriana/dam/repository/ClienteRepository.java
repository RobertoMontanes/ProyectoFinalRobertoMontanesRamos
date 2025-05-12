package com.salesianostriana.dam.repository;

import com.salesianostriana.dam.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}