package com.proyecto.gestorPedidos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.gestorPedidos.modelo.Pedido;
import com.proyecto.gestorPedidos.repositorio.IPedidoRepositorio;

@Service
public class PedidoServicio implements ICRUDServicio<Pedido> {

	
	@Autowired
	IPedidoRepositorio pedidoRepo;
	
	@Override
	public List<Pedido> listarElementos() {
		return pedidoRepo.findAll();
	}

	@Override
	public Pedido traerElemento(Long id) {
		return pedidoRepo.findById(id).orElse(null);
	}

	@Override
	public void guardarOModificarElemento(Pedido elem) {
		pedidoRepo.save(elem);
	}

	@Override
	public void eliminarElemento(Long id) {
		pedidoRepo.deleteById(id);	
	}

}
