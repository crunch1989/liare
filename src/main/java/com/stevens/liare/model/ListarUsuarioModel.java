
package com.stevens.liare.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ListarUsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;   
	   
	@Id   
	@Column(name = "C_PERL_CODIGO")
	private Long codigoUsuario;    

	@Column(name = "N_MST_DOMICILIO")
	private String domicilio;

	@Column(name = "D_MST_FECHANACIMIENTO")
	private String fechaNacimiento;       

	@Column(name = "N_MST_SEXO")
	private String sexo; //1 M y 0 F    

	@Column(name = "N_UNO_DESCRIPCION")
	private String oficina;    

	@Column(name = "N_MST_DNI")
	private String dni;
	
	@Column(name = "N_MST_NOMBRE")
	private String nombres;    

	@Column(name = "N_MST_APEPATERNO")
	private String apellidoPaterno;    

	@Column(name = "N_MST_APEMATERNO")
	private String apellidoMaterno;	

	@Column(name = "N_MST_LOGIN")
	private String userName;    
	
	@Column(name = "N_MST_EMAIL")
	private String email;    
	
	@Column(name = "C_SIT_CODIGO")
	private String estado;	
	

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
