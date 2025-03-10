package com.proyecto.gestorPedidos.excepciones;

public class InexistenteException extends Exception {

	private String mjs;
	
	//CONSTRUCTOR
	public InexistenteException(String msj) {
		this.mjs = msj;
	}
	
	
	//GETTERS Y SETTERS
	public void setMsj(String nuevoMsj) {
		this.mjs = nuevoMsj;
	}
	
	
	public String getMsj() {
		return this.mjs;
	}
}
