package com.salesianostriana.dam.service;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}