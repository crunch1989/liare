package com.stevens.liare.dto;

import java.io.Serializable;
import java.util.Date;


public class AuditoriaDTO implements Serializable {
	
    private static final long serialVersionUID = 5717722628013454193L;
    
    private String usuario;
    private String terminal;
    private Date fecha;      
   private Integer operacion;

	public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

	public Integer getOperacion() {
		return operacion;
	}

	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}
    
    
    

}
