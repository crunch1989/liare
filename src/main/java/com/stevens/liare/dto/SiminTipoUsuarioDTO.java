package com.stevens.liare.dto;

import java.io.Serializable;

public class SiminTipoUsuarioDTO implements Serializable {	

	private Long cTusuCodigo;   
	
	private String nTusuDescripcion;

	private Integer fTusuEstado;

	private String cTusuDetalle;

	
	
	public Long getcTusuCodigo() {
		return cTusuCodigo;
	}

	public void setcTusuCodigo(Long cTusuCodigo) {
		this.cTusuCodigo = cTusuCodigo;
	}

	public String getnTusuDescripcion() {
		return nTusuDescripcion;
	}

	public void setnTusuDescripcion(String nTusuDescripcion) {
		this.nTusuDescripcion = nTusuDescripcion;
	}

	public Integer getfTusuEstado() {
		return fTusuEstado;
	}

	public void setfTusuEstado(Integer fTusuEstado) {
		this.fTusuEstado = fTusuEstado;
	}

	public String getcTusuDetalle() {
		return cTusuDetalle;
	}

	public void setcTusuDetalle(String cTusuDetalle) {
		this.cTusuDetalle = cTusuDetalle;
	} 
	
	
	
	
	
	










}
