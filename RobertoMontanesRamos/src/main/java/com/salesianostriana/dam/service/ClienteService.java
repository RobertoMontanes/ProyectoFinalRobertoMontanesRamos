package com.salesianostriana.dam.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void guardar(Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
