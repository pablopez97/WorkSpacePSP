package com.videojuego.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.videojuego.modelo.entidad.Videojuego;
import com.videojuego.modelo.persistencia.DaoVidejuego;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private DaoVidejuego daoVidejuego;
	
	@GetMapping("videojuegos")
	public ResponseEntity<List<Videojuego>> listar(){
		
		List<Videojuego> lista = daoVidejuego.listado();
		
		ResponseEntity<List<Videojuego>> re = new ResponseEntity<List<Videojuego>>(lista, HttpStatus.OK);
		
		return re;
		
	}
	
	@GetMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> obtener(@PathVariable("id") int id_videojuego){
		
		Videojuego v1 = daoVidejuego.buscarPorId(id_videojuego);
		HttpStatus hs = null;
		
		if(v1 != null) {
			hs = HttpStatus.OK;
		}else {
			hs = HttpStatus.NOT_FOUND;	
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(v1,hs);
		
		return re;
		
	}
	
	@PostMapping("videojuegos")
	public ResponseEntity<Videojuego> alta(@RequestBody Videojuego v){
		
		Videojuego vAlta = daoVidejuego.alta(v);
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(vAlta, HttpStatus.CREATED);
		
		return re;
		
	}
	
	@PostMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> modificar(@RequestBody Videojuego v, @PathVariable("id") int id_videojuego){
		
		v.setId(id_videojuego);

		Videojuego vModificada = daoVidejuego.modificar(v);
		
		HttpStatus hs = null;
		if (vModificada != null) {
			
			hs = HttpStatus.OK;
			
		}else {
			
			hs = HttpStatus.NOT_FOUND;
			
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(vModificada, hs);
		
		return re;
	}
	
	@DeleteMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> borrar(@PathVariable("id") int id_videojuego){
		
		Videojuego v = daoVidejuego.borrar(id_videojuego);
		
		HttpStatus hs = null;
		
		if(v!=null) {
			
			hs = HttpStatus.OK;
			
		}else {
			
			hs = HttpStatus.NOT_FOUND;
			
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(v, hs);
		
		return re;
		
	}
	
}



















