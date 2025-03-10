package com.proyecto.gestorPedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan(basePackages = {"com.proyecto.modelo", "com.proyecto.enumerado"} )  // Indica dónde buscar las entidades
//@ComponentScan(basePackages = "com.proyecto")  // Escanea componentes, servicios y repositorios

public class GestorPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorPedidosApplication.class, args);
	}

}
