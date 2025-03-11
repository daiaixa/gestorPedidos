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
		return pedidoRepo.findById(id).orElse(null);
	}

	@Override
	public void guardarElemento(Pedido elem) throws InexistenteException{
		if (elem.getCliente().getId() == null || !clienteRepo.existsById(elem.getCliente().getId())) {
			throw new InexistenteException("No existe el numero de cliente");
		}
		pedidoRepo.save(elem);
	}

	@Override
	public void eliminarElemento(Long id) throws InexistenteException {
		if (!pedidoRepo.existsById(id)) {
			throw new InexistenteException("No existe en id del pedido proporcionado");
		}
		pedidoRepo.deleteById(id);	
	}

	@Override
	public void modificarElemento(Pedido elemNuevo, Long id) throws InexistenteException {
			Pedido ped = pedidoRepo.findById(id).orElse(null);

			if (ped == null) {
				throw new InexistenteException("No existe el numero de pedido");
			}
			if (ped.getCliente().getId() == null || !clienteRepo.existsById(elemNuevo.getCliente().getId())) {
				throw new InexistenteException("No existe el numero de cliente");
			}
			
			ped.setEstado(elemNuevo.getEstado());
			ped.setFechaEntregado(elemNuevo.getFechaEntregado());
			ped.setFechaPedido(elemNuevo.getFechaPedido());
			ped.setNroPedido(elemNuevo.getNroPedido());
			
			//Para evitar inconsistencias, buscamos el id del cliente y guardamos ese mismo que traemos.
			Cliente nuevoCliente = clienteRepo.findById(elemNuevo.getCliente().getId()).orElse(null); 
			ped.setCliente(nuevoCliente);//se supone que no deberia ser null, ya que se comprobo que exista el cliente previamente
						
			pedidoRepo.save(ped);
		}

	}


