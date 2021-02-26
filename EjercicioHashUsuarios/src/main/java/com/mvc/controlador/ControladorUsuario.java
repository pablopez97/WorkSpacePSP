package com.mvc.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.negocio.GestorUsuario;

@Controller
public class ControladorUsuario {
	

	@Autowired
	private GestorUsuario gestorUsuario;
	
	@PostMapping("doRegistro")
	public String registrarse(
			@RequestParam("nombre_usuario") String nombre,
			@RequestParam("pass") String password,
			Model model) throws NoSuchAlgorithmException {
		
		byte[] pw = password.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(pw);
		
		byte[] pwd = md.digest();
		String mensajeHashBase64 = Base64.getEncoder().encodeToString(pwd);
		System.err.println(mensajeHashBase64);
		
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setPassword(mensajeHashBase64);
		
		boolean registrado = gestorUsuario.altaUsuarios(user);
		
		if(registrado) {
			model.addAttribute("nombreUsuario", nombre);
			//vamos a inicio.html
			return "registro";
		}else {
			//vamos a error.html
			return "error";
		}
		
	}
	
	@PostMapping("doLogin")
	public String logarse(
			@RequestParam("nombre_usuario") String nombre,
			@RequestParam("pass") String password,
			Model model) throws NoSuchAlgorithmException {
		
		byte[] pw = password.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(pw);
		
		byte[] contrasenia = md.digest();
		String mensajeHashBase64 = Base64.getEncoder().encodeToString(contrasenia);
		System.out.println(mensajeHashBase64);
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(mensajeHashBase64);
		
		boolean validado = gestorUsuario.validarUsuario(usuario);
		
		if(validado) {
			
			//vamos a inicio.html
			model.addAttribute("nombreUsuario", nombre);
			return "inicio";
		}else {
			//vamos a error.html
			return "error";
		}
		
	}


}
