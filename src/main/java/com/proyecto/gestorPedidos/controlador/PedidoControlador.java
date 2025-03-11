package com.proyecto.gestorPedidos.controlador;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.proyecto.gestorPedidos.enumerado.EstadoPedido;
import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Pedido;
import com.proyecto.gestorPedidos.servicio.ClienteServicio;
import com.proyecto.gestorPedidos.servicio.PedidoServicio;


@RestController
@RequestMapping(path="api/pedido")
public class PedidoControlador {

	@Autowired
	PedidoServicio pedidoServ;
	@Autowired
	ClienteServicio clienteServ;
	
	
	//QH: Busca un pedido determinado segun su id
	@GetMapping("/buscar/{id}")
	public Pedido buscarPedidos(@PathVariable("id") Long id) {
		return pedidoServ.traerElemento(id);
		//CONTROLAR QUE SI ES NULL DEBERIA LANZAR UN ERROR
	}

	
	//QH: Lista todos los pedidos
	@GetMapping("/listar")
	public List<Pedido> listarPedidos() {
		return pedidoServ.listarElementos();
	}
	
	
	//QH: Lista aquellos pedidos segun el filtro de estado
	@GetMapping("/listar/{estado}")
	public List<Pedido> listarPedidosPendientes(@PathVariable("estado") EstadoPedido estadoPed ){
		
		Iterator<Pedido> listaPedidos = pedidoServ.listarElementos().iterator();
		
		List<Pedido> listaFiltrada = new ArrayList<Pedido>();
		
		while (listaPedidos.hasNext()) {
			Pedido pedido = listaPedidos.next();
			if (pedido.getEstado() == estadoPed) {
				listaFiltrada.add(pedido);
			}
		}
		return listaFiltrada;
	}
	
	
	//QH: Lista los pedidos de un determinado cliente segun su id
	@GetMapping("/listar/{id}")
	public List<Pedido> listarPorCliente(@PathVariable ("idCliente") Long id){
		if (id == null || !clienteServ.existeElemento(id)) {
			new InexistenteException("No existe el id del cliente proporcionado");
		}
		
		Iterator<Pedido> listaPedidos = pedidoServ.listarElementos().iterator();
		
		List<Pedido> listaPedidosCliente = new ArrayList<Pedido>();
		
		while (listaPedidos.hasNext()) {
			Pedido pedido = listaPedidos.next();
			if (pedido.getCliente().getId() == id) {
				listaPedidosCliente.add(pedido);
			}
		}
		
		return listaPedidosCliente;
	}
	
	
	//QH: Crea un nuevo pedido
	@PostMapping("/crear")
	public void crearElemento(@RequestBody Pedido pedido){
		try {
			pedidoServ.guardarElemento(pedido);
		} catch (InexistenteException e) {
			System.out.println(e.getMsj());;
		}
	}
	
	
	//QH: Modifica un pedido segun su id
	@PutMapping("/modificar/{id}")
	public void modificarElemento(@RequestBody Pedido pedido, @PathVariable("id") Long id) {
		try {
			pedidoServ.modificarElemento(pedido, id);
		} catch (InexistenteException e) {
			System.out.println(e.getMsj());;
			}
	}
	
	
	//QH: Elimina un pedido segun la id
	@DeleteMapping("/eliminar/{id}")
	public void eliminarPedido(@PathVariable("id") Long id) {
		try {
			pedidoServ.eliminarElemento(id);
		} catch (InexistenteException e) {
			System.out.println(e.getMsj());;
		}
	}

}

