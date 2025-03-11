package com.proyecto.gestorPedidos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	
	
	@GetMapping("/buscar/{id}")
	public Cliente buscarCliente(@PathVariable("id") Long id) {
		return clienteServ.traerElemento(id);
	}

	
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteServ.listarElementos();
	}
	
	
	@PostMapping("/crear")
	public void crear(@RequestBody Cliente cliente) {
		clienteServ.guardarElemento(cliente);
	}
	
	
	@PutMapping("/modificar/{id}")
	public void modificar(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
		try {
			clienteServ.modificarElemento(cliente, id);
		} catch (InexistenteException e) {
			System.out.println(e.getMsj()); //TENDRIA QUE TIRAR UN ERROR HTTP
		}
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarCliente(@PathVariable("id") Long id) {
		try {
			clienteServ.eliminarElemento(id);
		} catch (InexistenteException e) {
			System.out.println(e.getMsj());;
		}
	}

}
