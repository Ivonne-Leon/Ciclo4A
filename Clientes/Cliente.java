package com.misiontic2022.grupo51.tiendagenerica.tiendagenerica51.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Clientes")
public class Cliente {

	@Id
	private String id;
	private String cedulaCliente;
	private String nombreCliente;
	private String direccionCliente;
	private Long telefonoCliente;
	private String correoElectronico;
	
	public  Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String cedulaCliente, String nombreCliente, String direccionCliente, Long telefonoCliente, String correoElectronico) {
		super();
		this.cedulaCliente=cedulaCliente;
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
		this.telefonoCliente=telefonoCliente;
		this.correoElectronico=correoElectronico;
		
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCodigoProducto(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreProducto(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public double getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(Long telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	
}
