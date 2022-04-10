package com.stevens.liare.dto;

import java.io.Serializable;

public class SiminSistemaDTO implements Serializable {	

	private Long cSisCodigo;    

	private String nSisDescripcion;      

	private Integer fSisEstado;   

	private String nSisAbreviatura;    

	private String nSisObservacion; 

	private Integer cUnoCodigo;
	

	public Long getcSisCodigo() {
		return cSisCodigo;
	}

	public void setcSisCodigo(Long cSisCodigo) {
		this.cSisCodigo = cSisCodigo;
	}

	public String getnSisDescripcion() {
		return nSisDescripcion;
	}

	public void setnSisDescripcion(String nSisDescripcion) {
		this.nSisDescripcion = nSisDescripcion;
	}

	public Integer getfSisEstado() {
		return fSisEstado;
	}

	public void setfSisEstado(Integer fSisEstado) {
		this.fSisEstado = fSisEstado;
	}

	public String getnSisAbreviatura() {
		return nSisAbreviatura;
	}

	public void setnSisAbreviatura(String nSisAbreviatura) {
		this.nSisAbreviatura = nSisAbreviatura;
	}

	public String getnSisObservacion() {
		return nSisObservacion;
	}

	public void setnSisObservacion(String nSisObservacion) {
		this.nSisObservacion = nSisObservacion;
	}

	public Integer getcUnoCodigo() {
		return cUnoCodigo;
	}

	public void setcUnoCodigo(Integer cUnoCodigo) {
		this.cUnoCodigo = cUnoCodigo;
	}  


	
	








}
