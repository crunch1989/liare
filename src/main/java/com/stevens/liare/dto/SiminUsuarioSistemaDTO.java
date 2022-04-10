package com.stevens.liare.dto;

import java.io.Serializable;

public class SiminUsuarioSistemaDTO implements Serializable {	

	private Long cUsCodigo;

	private Integer fUsEstado; 
	
	private Long codUsuario;

	private Long codSistema;    

	private String sistema; 

	private Long codTipoUsuario;    

	private String tipoUsuario;
	
	

	public Long getcUsCodigo() {
		return cUsCodigo;
	}

	public void setcUsCodigo(Long cUsCodigo) {
		this.cUsCodigo = cUsCodigo;
	}

	public Integer getfUsEstado() {
		return fUsEstado;
	}

	public void setfUsEstado(Integer fUsEstado) {
		this.fUsEstado = fUsEstado;
	}

	public Long getCodSistema() {
		return codSistema;
	}

	public void setCodSistema(Long codSistema) {
		this.codSistema = codSistema;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Long getCodTipoUsuario() {
		return codTipoUsuario;
	}

	public void setCodTipoUsuario(Long codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	
	
	













}
