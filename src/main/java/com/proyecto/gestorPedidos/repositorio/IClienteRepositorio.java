package com.proyecto.gestorPedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.gestorPedidos.modelo.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Long>{

}
