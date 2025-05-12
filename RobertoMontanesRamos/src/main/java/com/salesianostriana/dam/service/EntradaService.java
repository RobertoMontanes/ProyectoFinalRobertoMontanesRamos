package com.salesianostriana.dam.service;

import com.salesianostriana.dam.model.Entrada;
import com.salesianostriana.dam.repository.EntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntradaService {

    private final EntradaRepository entradaRepository;

    public List<Entrada> findAll() {
        return entradaRepository.findAll();
    }

    public List<Entrada> findDisponibles() {
        return entradaRepository.findByVendidaFalse();
    }

    public Optional<Entrada> findById(Long id) {
        return entradaRepository.findById(id);
    }

    public Entrada save(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    public void delete(Entrada entrada) {
        entradaRepository.delete(entrada);
    }

    public void deleteById(Long id) {
        entradaRepository.deleteById(id);
    }

    public List<Entrada> findByCliente(Long clienteId) {
        return entradaRepository.findByClienteId(clienteId);
    }
}