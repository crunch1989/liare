package com.stevens.liare.security.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Usuario implements Serializable{			

	private static final long serialVersionUID = 1L;	

	@Id
	@Column(name="C_PERL_CODIGO")
	private Long idUsuario;		

	@Column(name="N_MST_LOGIN")
	private String username;

	@Column(name="N_MST_NOMBRE")
	private String nombres;

	@Column(name="N_MST_APEPATERNO")
	private String apellidoPaterno;

	@Column(name="N_MST_APEMATERNO")
	private String apellidoMaterno;
	
	@Column(name="N_MST_EMAIL")
	private String email;

	@Column(name="C_SIT_CODIGO")
	private Integer estado;  //estado

	@Column(name="N_MST_PASSWORD")		
	private String password;

	@Column(name="C_UNO_CODIGO_OFICINA")	
	private String codigoOficina;

	@Column(name="N_UNO_DESCRIPCION")	
	private String descripcionOficina;

	@Transient
	private List<RolesUsuario> roles;


	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getDescripcionOficina() {
		return descripcionOficina;
	}

	public void setDescripcionOficina(String descripcionOficina) {
		this.descripcionOficina = descripcionOficina;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RolesUsuario> getRoles() {
		return roles;
	}

	public void setRoles(List<RolesUsuario> roles) {
		this.roles = roles;
	}
	
	


}