package com.stevens.liare.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TotalRegistrosModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="TOTAL")
	private Long totalRegistros;
	

	public Long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	

	

	


}
