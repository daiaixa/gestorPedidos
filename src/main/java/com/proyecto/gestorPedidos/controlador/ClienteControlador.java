package com.proyecto.gestorPedidos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	//METODO POST -- para trer o modificar los clientes
	@PostMapping({"/modificar", "/crear"})
	public void crearOModificar(@RequestBody Cliente cliente) {
		clienteServ.guardarOModificarElemento(cliente);
	}
	
	//METODO DELETE -- para eliminar algun cliente
	
	//@DeleteMapping("/borrar/{id}") en el metodo utilizamos @PathVariable("id")
	//Se recibe por la ruta la variable id del elemento que se desea eliminar
	@DeleteMapping("/eliminar/{id}")
	public void eliminarCliente(@PathVariable("id") Long id) {
		clienteServ.eliminarElemento(id);
	}

}
