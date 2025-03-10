package com.proyecto.gestorPedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.gestorPedidos.modelo.Pedido;

public interface IPedidoRepositorio extends JpaRepository<Pedido, Long>{

}
