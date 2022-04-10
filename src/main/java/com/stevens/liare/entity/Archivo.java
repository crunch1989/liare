package com.stevens.liare.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ARCHIVO", schema="SYSTEM")
public class Archivo implements Serializable{
	
	private static final long  serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TT_ARCHIVO")
	@SequenceGenerator(name="SEQ_TT_ARCHIVO", sequenceName="SYSTEM.SEQ_TT_ARCHIVO", allocationSize=1)
	@Id
	@Column(name="IDARCHIVO")
	private long idarchivo;
	
	@Column(name = "IDTIPORELACION")
	private String tiporelacion;
	
	@Column(name = "IDRELACION")
	private long idrelacion;
	
	@Column(name = "NOMBRE")
    private String nombrearchivo; 
    
    @Column(name = "RUTAARCHIVO")
    private String patharchivo; 
    
    @Column(name = "TAMANO")
    private Long tamanioarchivo; 
    
    @Lob
    @Column(name = "ARCHIVO")
	private byte[] archivoadj;

    @Column(name="EXTENSION")
    private String tipodocumento;
    
    @Column(name="ESTADO")
	private Integer estado;

	public long getIdarchivo() {
		return idarchivo;
	}

	public void setIdarchivo(long idarchivo) {
		this.idarchivo = idarchivo;
	}

	public String getTiporelacion() {
		return tiporelacion;
	}

	public void setTiporelacion(String tiporelacion) {
		this.tiporelacion = tiporelacion;
	}

	

	

	public long getIdrelacion() {
		return idrelacion;
	}

	public void setIdrelacion(long idrelacion) {
		this.idrelacion = idrelacion;
	}

	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public String getPatharchivo() {
		return patharchivo;
	}

	public void setPatharchivo(String patharchivo) {
		this.patharchivo = patharchivo;
	}

	public Long getTamanioarchivo() {
		return tamanioarchivo;
	}

	public void setTamanioarchivo(Long tamanioarchivo) {
		this.tamanioarchivo = tamanioarchivo;
	}

	public byte[] getArchivoadj() {
		return archivoadj;
	}

	public void setArchivoadj(byte[] archivoadj) {
		this.archivoadj = archivoadj;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
  
	
	
	

}
