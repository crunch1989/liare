package com.stevens.liare.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListarArchivo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CATEGORIA")
	private long idcategoria;
	
	@Column(name="ITEMS")
	private String items;
	
	@Column(name="NOMBRE_CATEGORIA")
	private String nombreCategoria;
	
	@Column(name="RUTAARCHIVO")
	private String rutaArchivo;
	
	@Column(name="IDARCHIVO")
	private Long idarchivo;

	public long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(long idcategoria) {
		this.idcategoria = idcategoria;
	}

	
	
	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public Long getIdarchivo() {
		return idarchivo;
	}

	public void setIdarchivo(Long idarchivo) {
		this.idarchivo = idarchivo;
	}

	
	
	
	
	
}
