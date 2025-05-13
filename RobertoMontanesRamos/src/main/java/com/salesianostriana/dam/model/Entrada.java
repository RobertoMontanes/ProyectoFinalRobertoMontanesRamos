package com.salesianostriana.dam.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Entrada {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pelicula;
    private LocalDateTime fechaHora;
    private double precio;
    private boolean vendida;
    
    @Column(columnDefinition = "TEXT")
    private String imagenUrl; 
    
    @ManyToOne
    private Cliente cliente;
}