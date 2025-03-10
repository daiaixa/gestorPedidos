package com.proyecto.gestorPedidos.modelo;

import com.proyecto.gestorPedidos.enumerado.TipoDocumento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	@NotNull
	private long nroDocumento;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;
	
	@NotBlank
	private String direccion;
	
	@Email
	private String email;
	
	@NotBlank
	private String telefono;
	
	@Size(min = 0, max = 300)
	private String notas;
	

	// CONSTRUCTOR
	public Cliente () {}
	
	public Cliente(TipoDocumento tipoDoc, long nroDoc, String nombre, String apellido, String email, String telefono) {
		this.tipoDocumento = tipoDoc;
		this.nroDocumento = nroDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	
	
	// GETTERS Y SETTERS 
	public Long getId() {
		return id;
	}

	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	
	public long getNroDocumento() {
		return nroDocumento;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public String getApellido() {
		return apellido;
	}

	
	public String getDireccion() {
		return direccion;
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getTelefono() {
		return telefono;
	}

	
	public String getNotas() {
		return notas;
	}

	
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	
	public void setNroDocumento(long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public void setNotas(String notas) {
		this.notas = notas;
	}

	
	// METODOS
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cliente) {
			Cliente clie = (Cliente) obj;
			
			if (clie.getTipoDocumento() == this.tipoDocumento && clie.getNroDocumento() == this.nroDocumento) {
				return true;
			}
			return false;
		}
		return super.equals(obj);
	}
	
	
	
	
	
	
}
