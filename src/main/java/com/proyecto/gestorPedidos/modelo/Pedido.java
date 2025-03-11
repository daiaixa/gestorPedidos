package com.proyecto.gestorPedidos.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.gestorPedidos.enumerado.EstadoPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pedidos")
public class Pedido {
		
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private int nroPedido;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate fechaPedido;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaEntregado; //éste es opcional, cuando se entrega, se edita la fecha por ejemplo
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	
	
	
	//CONSTRUCTOR
	public Pedido() { //son obligatorios y necesarios para implementar hibernate/JPA
		this.estado =EstadoPedido.EN_PROCESO;
	}
	
	public Pedido(int nroPed, LocalDate fechaPedido, Cliente idCliente) {
		this();
		this.nroPedido = nroPed;
		this.fechaPedido = fechaPedido;
		this.cliente = idCliente;
	}

	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}
	
	
	public int getNroPedido() {
		return nroPedido;
	}


	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	
	
	public EstadoPedido getEstado() {
		return estado;
	}
	
	
	public LocalDate getFechaEntregado() {
		return fechaEntregado;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	
	public void setFechaEntregado(LocalDate fechaEntregado) {
		this.fechaEntregado = fechaEntregado;
	}
	
	
	public void setCliente(Cliente idCliente) {
		this.cliente = idCliente;
	}

	
	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}


	

	//METODOS 
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Pedido) {
			Pedido ped = (Pedido) obj;
			
			if (ped.getNroPedido() == this.nroPedido && ped.getCliente().equals(cliente)) {
				return true;
			}
			
			return false;
		}
		return super.equals(obj);
	}

	
	
}
