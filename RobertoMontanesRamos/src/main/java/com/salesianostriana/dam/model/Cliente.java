package com.salesianostriana.dam.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data 
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Cliente {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Entrada> entradas = new ArrayList<>();

    public void addEntrada(Entrada e) {
        e.setCliente(this);
        this.entradas.add(e);
    }

    public void removeEntrada(Entrada e) {
        e.setCliente(null);
        this.entradas.remove(e);
    }
}