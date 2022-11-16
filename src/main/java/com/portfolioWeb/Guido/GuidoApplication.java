package com.portfolioWeb.Guido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuidoApplication.class, args);
	}

}

//IMPORTANTE: CUANDO HAGA EL CRUD, EN LA CLASE CONTROLLER TENGO QUE AGREGAR
//LA ANOTACIÓN @PreAuthorize("hasRole('ADMIN')") en los métodos que son sólo
//para adiinistrador (create, edit, etc) capitulo 6
