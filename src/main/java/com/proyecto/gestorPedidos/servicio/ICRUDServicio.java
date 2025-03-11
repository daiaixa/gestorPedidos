package com.proyecto.gestorPedidos.servicio;

import java.util.List;

import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Cliente;

public interface ICRUDServicio<T> {

	
		//QH: Lista todas las tuplas de la entidad
		List<T> listarElementos();		
		//QH: Busca un elemento segun el id
		T traerElemento(Long id);		
		//QH: Almacena un elemento
		void guardarElemento(T elem) throws InexistenteException;
		//QH: Modifica un elemento
		void modificarElemento(T elemNuevo, Long id) throws InexistenteException;
		//QH: Elimina un elemento por medio de su id
		void eliminarElemento(Long id) throws InexistenteException;
		
		
		

}
