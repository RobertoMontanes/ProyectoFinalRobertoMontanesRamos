package com.salesianostriana.dam.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String email;
	private String telefono;
	
	

}