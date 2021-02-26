package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.persistencia.DaoUsuario;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		DaoUsuario du = context.getBean("daoUsuario", DaoUsuario.class);
	
		Usuario u = new Usuario();
		u.setNombre("pablo");
		u.setPassword("123456");
		
		du.save(u);
	}

}
