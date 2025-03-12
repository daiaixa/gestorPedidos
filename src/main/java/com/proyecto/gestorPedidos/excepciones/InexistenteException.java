package com.proyecto.gestorPedidos.excepciones;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InexistenteException extends RuntimeException {
	//¿Porque? porque de esa forma no me obluga a capturarla con un try chatch

	
	//CONSTRUCTOR
	public InexistenteException(String msj) {
		super(msj);
	}
	
}
