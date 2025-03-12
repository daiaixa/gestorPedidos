package com.proyecto.gestorPedidos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Cliente;
import com.proyecto.gestorPedidos.servicio.ClienteServicio;


@RestController
@RequestMapping(path="api/cliente") //La ruta inicial
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServ;
	
	
	
	//QH: Trae los datos de un cliente segun el id
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarCliente(@PathVariable("id") Long id) {
		Cliente cliente = clienteServ.traerElemento(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	
	//QH: Lista todos los clientes
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteServ.listarElementos());
	}
	
	
	//QH: Crea un nuevo cliente	
	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestBody Cliente cliente) {
		clienteServ.guardarElemento(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("El recurso fue creado con exito.");
	}
	
	
	//QH: Modifica un cliente segun el id
	@PutMapping("/modificar/{id}")
	public ResponseEntity<String> modificar(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
		clienteServ.modificarElemento(cliente, id);
		return ResponseEntity.status(HttpStatus.OK).body("El recurso fue modificado con exito");
	}
	
	
	//QH: Elimina un cliente segun el id 
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarCliente(@PathVariable("id") Long id) {
		clienteServ.eliminarElemento(id);
		return ResponseEntity.status(HttpStatus.OK).body("El recurso se eliminó con exito.");
	}

}
