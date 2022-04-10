package com.stevens.liare.entity;





import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA", schema = "SYSTEM")
public class CategoriaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TT_CATEGORIA") 
	@SequenceGenerator(name = "SEQ_TT_CATEGORIA", sequenceName = "SYSTEM.SEQ_TT_CATEGORIA", schema = "SYSTEM", allocationSize = 1)
	private long id_categoria;
	
	@Column(name="NOMBRE_CATEGORIA")
	private String nombre_categoria;
			
	@Column(name="ESTADO")
	private Integer estado;
	
	@Column(name = "IDARCHIVO")
	private long idtbarchivo;
	


	

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public long getIdtbarchivo() {
		return idtbarchivo;
	}

	public void setIdtbarchivo(long idtbarchivo) {
		this.idtbarchivo = idtbarchivo;
	}

	

	
	
	
	
	
	
	
	
}
