package com.proyecto.gestorPedidos.modelo;

import java.time.LocalDate;

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
	@NotNull
	private LocalDate fechaPedido;
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;
	private LocalDate fechaEntregado; //éste es opcional, cuando se entrega, se edita la fecha por ejemplo
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente idCliente;
	
	//CONSTRUCTOR
	public Pedido(int nroPed) {
		this.nroPedido = nroPed;
	}

	
	public Pedido(int nroPed, LocalDate fechaPedido, Cliente idCliente) {
		this(nroPed);
		this.fechaPedido = fechaPedido;
		this.estado =EstadoPedido.EN_PROCESO;
		this.idCliente = idCliente;
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
	
	
	public Cliente getIdCliente() {
		return idCliente;
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
	
	
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	
	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}


	

	//METODOS 
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Pedido) {
			Pedido ped = (Pedido) obj;
			
			if (ped.getNroPedido() == this.nroPedido && ped.getIdCliente().equals(idCliente)) {
				return true;
			}
			
			return false;
		}
		return super.equals(obj);
	}

	
	
}
