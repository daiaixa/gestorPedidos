package com.proyecto.gestorPedidos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Cliente;
import com.proyecto.gestorPedidos.modelo.Pedido;
import com.proyecto.gestorPedidos.repositorio.IClienteRepositorio;
import com.proyecto.gestorPedidos.repositorio.IPedidoRepositorio;

@Service
public class PedidoServicio implements ICRUDServicio<Pedido> {

	
	@Autowired
	IPedidoRepositorio pedidoRepo;
	@Autowired
	IClienteRepositorio clienteRepo; //para comprobar que el id del cliente sea existente
	
	@Override
	public List<Pedido> listarElementos() {
		return pedidoRepo.findAll();
	}

	@Override
	public Pedido traerElemento(Long id) {
		return pedidoRepo.findById(id)
				.orElseThrow(() -> new InexistenteException("No se encontró el recurso con el id" + id));
	}

	@Override
	public void guardarElemento(Pedido elem) {
		if (elem.getCliente().getId() == null || !clienteRepo.existsById(elem.getCliente().getId())) {
			throw new InexistenteException("No existe el numero de cliente");
		}
		pedidoRepo.save(elem);
	}

	@Override
	public void eliminarElemento(Long id) throws InexistenteException {
		Pedido pedido = pedidoRepo.findById(id).orElseThrow(()-> new InexistenteException("No se encontro el recurso con el id "+ id));
		pedidoRepo.delete(pedido);	
	}

	@Override
	public void modificarElemento(Pedido elemNuevo, Long id) {
			Pedido ped = pedidoRepo.findById(id)
					.orElseThrow(()-> new InexistenteException("No se encontró el recurso con el id "+ id));
		
			ped.setEstado(elemNuevo.getEstado());
			ped.setFechaEntregado(elemNuevo.getFechaEntregado());
			ped.setFechaPedido(elemNuevo.getFechaPedido());
			ped.setNroPedido(elemNuevo.getNroPedido());
			
			//Para evitar inconsistencias, buscamos el id del cliente y guardamos ese mismo que traemos.
			Cliente nuevoCliente = clienteRepo.findById(elemNuevo.getCliente().getId())
					.orElseThrow(()-> new InexistenteException("No se encontró el recurso")); 
			
			ped.setCliente(nuevoCliente);//se supone que no deberia ser null, ya que se comprobo que exista el cliente previamente
						
			pedidoRepo.save(ped);
		}

	}


