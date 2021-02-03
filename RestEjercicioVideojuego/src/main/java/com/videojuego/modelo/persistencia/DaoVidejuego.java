package com.videojuego.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.videojuego.modelo.entidad.Videojuego;

@Component
public class DaoVidejuego {
	
	private List<Videojuego> listaVideojuegos;
	private int contador = 0;
	
	public DaoVidejuego() {
		
		Videojuego v1 = new Videojuego();
		v1.setId(contador++);
		v1.setNombre("Grand theft auto");
		v1.setCompania("RockStar");
		v1.setPrecio(65.3);
		v1.setPuntuacion(9.5);
		
		Videojuego v2 = new Videojuego();
		v2.setId(contador++);
		v2.setNombre("FIFA 2020");
		v2.setCompania("EA Sports");
		v2.setPrecio(55);
		v2.setPuntuacion(8);
		
		listaVideojuegos = new ArrayList<Videojuego>();
		listaVideojuegos.add(v1);
		listaVideojuegos.add(v2);
		
	}
	
	public List<Videojuego> listado(){
		return listaVideojuegos;
	}

	public Videojuego buscarPorId(int id) {
		
		Videojuego videojuego = null;
		
		for (Videojuego v : listaVideojuegos) {
			if (v.getId() == id) {
				
				videojuego = v;
				break;
				
			}
		}
		
		return videojuego;
	}

	public Videojuego alta(Videojuego v) {
		
		//PARA INTRODUCIR LOS DATOS DE LOS VIDEOJUEGOS SE HARA EN LA APLICACION DE POSTMAN
		//EN EL APARTADO DE BODY EN LA INSTRUCCION DE TIPO POST
		
		v.setId(contador++);
		listaVideojuegos.add(v);
		return v;
		
	}

	public Videojuego modificar(Videojuego v) {
		
		Videojuego v1 = buscarPorId(v.getId());
		
		if(v1!=null) {
			
			v1.setCompania(v.getCompania());
			v1.setNombre(v.getNombre());
			v1.setPuntuacion(v.getPuntuacion());
			v1.setPrecio(v.getPrecio());
			
		}
		
		return v1;
	}

	public Videojuego borrar(int id_videojuego) {
		
		Videojuego v = buscarPorId(id_videojuego);
		
		if(v!=null) {
			
			listaVideojuegos.remove(id_videojuego);
			
		}
		
		return v;
	}
	
}
