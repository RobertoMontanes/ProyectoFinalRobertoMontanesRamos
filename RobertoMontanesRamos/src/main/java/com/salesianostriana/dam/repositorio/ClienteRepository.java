package com.salesianostriana.dam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
