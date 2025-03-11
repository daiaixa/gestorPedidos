package com.proyecto.gestorPedidos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.gestorPedidos.excepciones.InexistenteException;
import com.proyecto.gestorPedidos.modelo.Cliente;
import com.proyecto.gestorPedidos.repositorio.IClienteRepositorio;

@Service
public class ClienteServicio implements ICRUDServicio<Cliente> {

	// inyectamos el repositorio
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
	public void guardarElemento(Cliente elem) {
		clienteRepo.save(elem);
	}

	@Override
	public void eliminarElemento(Long id) throws InexistenteException {
		if (!clienteRepo.existsById(id)) {
			throw new InexistenteException("No existe en id del pedido proporcionado");
		}
		clienteRepo.deleteById(id);
	}

	public boolean existeElemento(Long id) {
		return clienteRepo.existsById(id);
	}

	@Override
	public void modificarElemento(Cliente elemNuevo, Long id) throws InexistenteException {
		Cliente clie = clienteRepo.findById(id).orElse(null);

		if (clie == null) {
			throw new InexistenteException("No existe el numero de cliente");
		}

		clie.setNombre(elemNuevo.getNombre());
		clie.setApellido(elemNuevo.getApellido());
		clie.setTipoDocumento(elemNuevo.getTipoDocumento());
		clie.setNroDocumento(elemNuevo.getNroDocumento());
		clie.setDireccion(elemNuevo.getDireccion());
		clie.setEmail(elemNuevo.getEmail());
		clie.setTelefono(elemNuevo.getTelefono());
		clie.setNotas(elemNuevo.getNotas());
		clienteRepo.save(clie);
	}

}
