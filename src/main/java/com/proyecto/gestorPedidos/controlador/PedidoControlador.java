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

import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Pedido;
import com.proyecto.gestorPedidos.servicio.ClienteServicio;
import com.proyecto.gestorPedidos.servicio.PedidoServicio;


@RestController
@RequestMapping(path="api/pedido")
public class PedidoControlador {

	@Autowired
	PedidoServicio pedidoServ;
	ClienteServicio clienteServ;
	
	
	
	@GetMapping("/buscar/{id}")
	public Pedido buscarPedidos(@PathVariable("id") Long id) {
		return pedidoServ.traerElemento(id);
	}

	@GetMapping("/listar")
	public List<Pedido> listarPedidos() {
		return pedidoServ.listarElementos();
	}
	
	//METODO POST -- para trer o modificar los clientes
	@PostMapping({"/crear", "/modificar"})
	public void crearOModificar(@RequestBody Pedido pedido) throws InexistenteException {
		if (pedido.getCliente().getId()==null || !clienteServ.existeElemento(pedido.getCliente().getId())) {
			throw new InexistenteException("El numero de cliente no se encuentra registrado");
		}
		pedidoServ.guardarOModificarElemento(pedido);
	}
	
	
	//@DeleteMapping("/borrar/{id}") en el metodo utilizamos @PathVariable("id")
	//Se recibe por la ruta la variable id del elemento que se desea eliminar
	@DeleteMapping("/eliminar/{id}")
	public void eliminarPedido(@PathVariable("id") Long id) {
		pedidoServ.eliminarElemento(id);
	}

}


//TODO listar pedidos por clientes, el cliente de un determinado pedido... 