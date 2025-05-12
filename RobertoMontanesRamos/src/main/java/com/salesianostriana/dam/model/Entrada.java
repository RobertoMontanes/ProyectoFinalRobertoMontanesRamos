package com.salesianostriana.dam.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Entrada {

    @Id @GeneratedValue
    private Long id;

    private String pelicula;
    private LocalDateTime fechaHora;
    private double precio;
    private boolean vendida;

    @ManyToOne
    private Cliente cliente;
}