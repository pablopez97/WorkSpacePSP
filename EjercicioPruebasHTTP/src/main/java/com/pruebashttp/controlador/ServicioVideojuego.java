package com.pruebashttp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebashttp.modelo.entidad.Videojuego;

@RestController
public class ServicioVideojuego {

	@Autowired
	private Videojuego vj; 

	@GetMapping("videjuego")
	public Videojuego obtenerVideojuego() {

		return vj;
		
	}
	
	@PutMapping("precio")
	public String cambiarPrecioVideojuego() {
		
		vj.setPrecio(70);
		
		return "Precio del juego cambiado";
		
	}
	

}
