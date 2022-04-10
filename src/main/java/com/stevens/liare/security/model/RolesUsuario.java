package com.stevens.liare.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RolesUsuario implements Serializable{

	private static final long serialVersionUID = 1L;	

	@Id
	@Column(name="ID_ROL")
	private Long idRol;		

	@Column(name="DESCRIPCION_ROL")
	private String descripcion;
	
	@Column(name="ALIAS_ROL")
	private String alias;
	
	

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
	
	
	
	
}