package com.salesianostriana.dam.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private int duracion; 
    private String genero;
    private double precioEntrada;
    private String imagenUrl;

    @ManyToMany(mappedBy = "peliculas")
    private List<Cliente> clientes;
}
