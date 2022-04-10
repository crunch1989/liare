package com.stevens.liare.dto;

import java.io.Serializable;

public class SiminMaestroDTO implements Serializable {	

	private Long cPerlCodigo;	

	private String nMstDni;

	private String nMstApepaterno;	

	private String nMstApematerno;	

	private String nMstNombre;	

	private String nMstDomicilio;

	private String fechaNacimiento;	

	private String nMstSexo;	

	private String fechaInMin;//fecha de ingreso al ministerio

	private String cSitCodigo;//situacion del usuario

	private String cTingCodigo;//tipo de regimen
	
	private String cEstcCodigo;//estado civil

	private Long codOficDestaque; //fk

	private Long codOficina;//fk

	//private String cMstCodDomi;// examle 150132

	private String nMstLogin;

	private String password;

	private String nMstEmail;

	private String cMstDomicilioDep;

	private String cMstDomicilioProv;

	private String cMstDomicilioDis;

	private String cMstLugnacimDep;

	private String cMstLugnacimProv;

	private String cMstLugnacimDis;

	private String mMstTelefono;
	
	private String mMstCelular;
	
	private String mMstRuc;
	
	//private Integer fMstPrimeravez;
	
	private String descOficinaDestaque;
	
	private String descOficina;
	
	

	public Long getcPerlCodigo() {
		return cPerlCodigo;
	}

	public void setcPerlCodigo(Long cPerlCodigo) {
		this.cPerlCodigo = cPerlCodigo;
	}

	public String getnMstDni() {
		return nMstDni;
	}

	public void setnMstDni(String nMstDni) {
		this.nMstDni = nMstDni;
	}

	public String getnMstApepaterno() {
		return nMstApepaterno;
	}

	public void setnMstApepaterno(String nMstApepaterno) {
		this.nMstApepaterno = nMstApepaterno;
	}

	public String getnMstApematerno() {
		return nMstApematerno;
	}

	public void setnMstApematerno(String nMstApematerno) {
		this.nMstApematerno = nMstApematerno;
	}

	public String getnMstNombre() {
		return nMstNombre;
	}

	public void setnMstNombre(String nMstNombre) {
		this.nMstNombre = nMstNombre;
	}

	public String getnMstDomicilio() {
		return nMstDomicilio;
	}

	public void setnMstDomicilio(String nMstDomicilio) {
		this.nMstDomicilio = nMstDomicilio;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getnMstSexo() {
		return nMstSexo;
	}

	public void setnMstSexo(String nMstSexo) {
		this.nMstSexo = nMstSexo;
	}

	public String getFechaInMin() {
		return fechaInMin;
	}

	public void setFechaInMin(String fechaInMin) {
		this.fechaInMin = fechaInMin;
	}

	public String getcSitCodigo() {
		return cSitCodigo;
	}

	public void setcSitCodigo(String cSitCodigo) {
		this.cSitCodigo = cSitCodigo;
	}

	public String getcTingCodigo() {
		return cTingCodigo;
	}

	public void setcTingCodigo(String cTingCodigo) {
		this.cTingCodigo = cTingCodigo;
	}

	public String getcEstcCodigo() {
		return cEstcCodigo;
	}

	public void setcEstcCodigo(String cEstcCodigo) {
		this.cEstcCodigo = cEstcCodigo;
	}

	public Long getCodOficDestaque() {
		return codOficDestaque;
	}

	public void setCodOficDestaque(Long codOficDestaque) {
		this.codOficDestaque = codOficDestaque;
	}

	public Long getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(Long codOficina) {
		this.codOficina = codOficina;
	}

	/*public String getcMstCodDomi() {
		return cMstCodDomi;
	}

	public void setcMstCodDomi(String cMstCodDomi) {
		this.cMstCodDomi = cMstCodDomi;
	}*/	

	public String getnMstLogin() {
		return nMstLogin;
	}

	public void setnMstLogin(String nMstLogin) {
		this.nMstLogin = nMstLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getnMstEmail() {
		return nMstEmail;
	}

	public void setnMstEmail(String nMstEmail) {
		this.nMstEmail = nMstEmail;
	}

	public String getcMstDomicilioDep() {
		return cMstDomicilioDep;
	}

	public void setcMstDomicilioDep(String cMstDomicilioDep) {
		this.cMstDomicilioDep = cMstDomicilioDep;
	}

	public String getcMstDomicilioProv() {
		return cMstDomicilioProv;
	}

	public void setcMstDomicilioProv(String cMstDomicilioProv) {
		this.cMstDomicilioProv = cMstDomicilioProv;
	}

	public String getcMstDomicilioDis() {
		return cMstDomicilioDis;
	}

	public void setcMstDomicilioDis(String cMstDomicilioDis) {
		this.cMstDomicilioDis = cMstDomicilioDis;
	}

	public String getcMstLugnacimDep() {
		return cMstLugnacimDep;
	}

	public void setcMstLugnacimDep(String cMstLugnacimDep) {
		this.cMstLugnacimDep = cMstLugnacimDep;
	}

	public String getcMstLugnacimProv() {
		return cMstLugnacimProv;
	}

	public void setcMstLugnacimProv(String cMstLugnacimProv) {
		this.cMstLugnacimProv = cMstLugnacimProv;
	}

	public String getcMstLugnacimDis() {
		return cMstLugnacimDis;
	}

	public void setcMstLugnacimDis(String cMstLugnacimDis) {
		this.cMstLugnacimDis = cMstLugnacimDis;
	}

	public String getmMstTelefono() {
		return mMstTelefono;
	}

	public void setmMstTelefono(String mMstTelefono) {
		this.mMstTelefono = mMstTelefono;
	}

	public String getmMstCelular() {
		return mMstCelular;
	}

	public void setmMstCelular(String mMstCelular) {
		this.mMstCelular = mMstCelular;
	}

	public String getmMstRuc() {
		return mMstRuc;
	}

	public void setmMstRuc(String mMstRuc) {
		this.mMstRuc = mMstRuc;
	}

	public String getDescOficinaDestaque() {
		return descOficinaDestaque;
	}

	public void setDescOficinaDestaque(String descOficinaDestaque) {
		this.descOficinaDestaque = descOficinaDestaque;
	}

	public String getDescOficina() {
		return descOficina;
	}

	public void setDescOficina(String descOficina) {
		this.descOficina = descOficina;
	}

	/*public Integer getfMstPrimeravez() {
		return fMstPrimeravez;
	}

	public void setfMstPrimeravez(Integer fMstPrimeravez) {
		this.fMstPrimeravez = fMstPrimeravez;
	}*/
	
	
	
	
	
	




}
