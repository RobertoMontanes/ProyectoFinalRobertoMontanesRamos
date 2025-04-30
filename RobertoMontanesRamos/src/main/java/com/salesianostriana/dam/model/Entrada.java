package com.salesianostriana.dam.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrada {

	@Id
	@GeneratedValue
	private Long id;
	private String tituloPelicula;
	private LocalDateTime fechaHoraSesion;
	private int cantidad;
	private double precio;

}
