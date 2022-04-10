package com.stevens.liare.dto;

import java.io.Serializable;

public class CambioClaveDTO implements Serializable {	

	private Long codUsuario;	

	private String fullName;	

	private String domicilio;
	
	private String userName;

	private String password;

	private String email;
	
	private String telefono;
	
	private String celular;		
	
	private String descOficina;
	
	

	public Long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDescOficina() {
		return descOficina;
	}

	public void setDescOficina(String descOficina) {
		this.descOficina = descOficina;
	}
	
	
	
	
	
	
	
	




}
