package com.stevens.liare.dto;

import java.io.Serializable;

public class FiltroUsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = -211437371616215921L;

	private String dni;
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private Integer exportaExcel;

	private String textoBusqueda;
	
	

	public Integer getExportaExcel() {
		return exportaExcel;
	}

	public void setExportaExcel(Integer exportaExcel) {
		this.exportaExcel = exportaExcel;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	

}
