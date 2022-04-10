package com.stevens.liare.controller.dto;

import java.io.Serializable;
public class FirmaParametros implements Serializable {

	private static final long serialVersionUID = -4931248240924241793L;
	

	private String firma_vobo;
	private String documentName;
	private int contadorVoBo;
	private String serverPath;
	private String protocol;
	private String fileDownloadUrl;
	private String fileUploadUrl;
	private String idFile;
	private String type;
	private String fecha_consulta;
	private Integer idoblreg;
	public String getFirma_vobo() {
		return firma_vobo;
	}
	public void setFirma_vobo(String firma_vobo) {
		this.firma_vobo = firma_vobo;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public int getContadorVoBo() {
		return contadorVoBo;
	}
	public void setContadorVoBo(int contadorVoBo) {
		this.contadorVoBo = contadorVoBo;
	}
	public String getServerPath() {
		return serverPath;
	}
	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}
	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}
	public String getFileUploadUrl() {
		return fileUploadUrl;
	}
	public void setFileUploadUrl(String fileUploadUrl) {
		this.fileUploadUrl = fileUploadUrl;
	}
	public String getIdFile() {
		return idFile;
	}
	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFecha_consulta() {
		return fecha_consulta;
	}
	public void setFecha_consulta(String fecha_consulta) {
		this.fecha_consulta = fecha_consulta;
	}
	public Integer getIdoblreg() {
		return idoblreg;
	}
	public void setIdoblreg(Integer idoblreg) {
		this.idoblreg = idoblreg;
	}
	
	
	
	
}
