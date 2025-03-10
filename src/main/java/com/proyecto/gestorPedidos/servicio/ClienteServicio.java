package com.proyecto.gestorPedidos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.gestorPedidos.modelo.Cliente;
import com.proyecto.gestorPedidos.repositorio.IClienteRepositorio;

@Service
public class ClienteServicio implements ICRUDServicio<Cliente>{

	//inyectamos el repositorio
	@Autowired
	IClienteRepositorio clienteRepo;

	@Override
	public List<Cliente> listarElementos() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente traerElemento(Long id) {
		return clienteRepo.findById(id).orElse(null);
	}

	@Override
	public void guardarOModificarElemento(Cliente elem) {
		clienteRepo.save(elem);		
	}


	@Override
	public void eliminarElemento(Long id) {
		clienteRepo.deleteById(id);
	}
	
	
	public boolean existeElemento(Long id) {
		return clienteRepo.existsById(id);
	}
	
	}
