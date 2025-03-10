package com.proyecto.gestorPedidos.servicio;

import java.util.List;

import com.proyecto.gestorPedidos.modelo.Cliente;

public interface ICRUDServicio<T> {

	
		//QH: Lista todas las tuplas de clientes
		List<T> listarElementos();		
		//QH: Busca la tupla de un cliente por medio del id
		T traerElemento(Long id);		
		//QH: Almacena un elemento dentro de la tabla clientes
		void guardarOModificarElemento(T elem);
		//QH: Elimina un elemento por medio de su id
		void eliminarElemento(Long id);
		
		
		

}
