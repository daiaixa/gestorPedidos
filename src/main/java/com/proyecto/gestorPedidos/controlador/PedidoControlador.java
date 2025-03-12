package com.proyecto.gestorPedidos.controlador;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.proyecto.gestorPedidos.enumerado.EstadoPedido;
import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Pedido;
import com.proyecto.gestorPedidos.servicio.ClienteServicio;
import com.proyecto.gestorPedidos.servicio.PedidoServicio;

@RestController
@RequestMapping(path = "api/pedido")
public class PedidoControlador {

	@Autowired
	PedidoServicio pedidoServ;
	@Autowired
	ClienteServicio clienteServ;

	
	
	// QH: Busca un pedido determinado segun su id
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Pedido> buscarPedidos(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(pedidoServ.traerElemento(id));
	}

	
	// QH: Lista todos los pedidos
	@GetMapping("/listar")
	public ResponseEntity<List<Pedido>> listarPedidos() {
		return ResponseEntity.status(HttpStatus.OK).body(pedidoServ.listarElementos());
	}

	
	// QH: Lista aquellos pedidos segun el filtro de estado
	@GetMapping("/listar/{estado}")
	public ResponseEntity<List<Pedido>> listarPedidosPendientes(@PathVariable("estado") EstadoPedido estadoPed) {

		Iterator<Pedido> listaPedidos = pedidoServ.listarElementos().iterator();

		List<Pedido> listaFiltrada = new ArrayList<Pedido>();

		while (listaPedidos.hasNext()) {
			Pedido pedido = listaPedidos.next();
			if (pedido.getEstado() == estadoPed) {
				listaFiltrada.add(pedido);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(listaFiltrada);
	}

	
	// QH: Lista los pedidos de un determinado cliente segun su id
	@GetMapping("/listar/{id}")
	public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable("id") Long id) {
		if (id == null || !clienteServ.existeElemento(id)) {
			throw new InexistenteException("No existe el id del cliente proporcionado");
		}

		Iterator<Pedido> listaPedidos = pedidoServ.listarElementos().iterator();

		List<Pedido> listaPedidosCliente = new ArrayList<Pedido>();

		while (listaPedidos.hasNext()) {
			Pedido pedido = listaPedidos.next();
			if (pedido.getCliente().getId() == id) {
				listaPedidosCliente.add(pedido);
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(listaPedidosCliente);
	}

	
	// QH: Crea un nuevo pedido
	@PostMapping("/crear")
	public ResponseEntity<String> crearElemento(@RequestBody Pedido pedido) {
		pedidoServ.guardarElemento(pedido);
		return ResponseEntity.status(HttpStatus.OK).body("El recurso fue creado con exito.");
	}

	
	// QH: Modifica un pedido segun su id
	@PutMapping("/modificar/{id}")
	public ResponseEntity<String> modificarElemento(@RequestBody Pedido pedido, @PathVariable("id") Long id) {
			pedidoServ.modificarElemento(pedido, id);
			return ResponseEntity.status(HttpStatus.OK).body("El recurso fue modificado correctamente");

	}

	
	// QH: Elimina un pedido segun la id
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarPedido(@PathVariable("id") Long id) {
			pedidoServ.eliminarElemento(id);
			return ResponseEntity.status(HttpStatus.OK).body("El recurso se eliminó correctamente");
	}
}
