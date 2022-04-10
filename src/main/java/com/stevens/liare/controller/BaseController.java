package com.stevens.liare.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.stevens.liare.dto.AuditoriaDTO;
import com.stevens.liare.security.service.UserPrincipal;
import com.stevens.liare.util.ConstantesUtil;
import com.stevens.liare.util.StringUtil;


public class BaseController {

	protected final Log logger = LogFactory.getLog(this.getClass());


	protected boolean _isEmpty(Object object) {
		return StringUtil.isEmpty(object);
	}

	protected boolean _equiv(Object obj1, Object obj2) {
		return StringUtil.equiv(obj1, obj2);
	}

	protected AuditoriaDTO obtenerAuditoria() {

		AuditoriaDTO auditoriaDTO = new AuditoriaDTO();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		String direccionRemota = request.getRemoteAddr();

		if (!_isEmpty(auth)) {			
			UserPrincipal usuario = (UserPrincipal)auth.getPrincipal();			
			auditoriaDTO.setUsuario(String.valueOf(usuario.getId()));
		}

		if (direccionRemota == null) {
			direccionRemota = "????";
		}

		auditoriaDTO.setTerminal(direccionRemota);
		auditoriaDTO.setFecha(new Date());

		return auditoriaDTO;
	}

	
	//CONFIGURAR TABLA DE ACCIONES PARA MANTENEDOR USUARIO

	public String obtenerAccionesTabla(String id, ArrayList<String> valores) {
		String html = "";
		for (String valor : valores) {
			html += configurarAccionesTabla(id, valor);
		}		
		return html;
	}


	private String configurarAccionesTabla(String id, String accion) {

		String icon = "";	
		String metodo = "";	
		
		if (_equiv(accion, ConstantesUtil.BTN_EDITAR_USUARIO)) {			
			icon = "fas fa-edit";
			metodo = "editarUsuario";	
			
			return "<button  title='"
			+ accion
			+ "' class='btn waves-effect waves-light btn-rounded btn-info' onclick=\""
			+ metodo + "('" + id + "')\"><i class='" + icon
			+ "'></i> </button>";		
			
		}else if (_equiv(accion, ConstantesUtil.BTN_USUARIO_SISTEMA)) {			
			icon = "fas fa-eye";
			metodo = "verUsuarioSistema";	
			
			return "<button  title='"
			+ accion
			+ "' class='btn waves-effect waves-light btn-rounded btn-info' onclick=\""
			+ metodo + "('" + id + "')\"><i class='" + icon
			+ "'></i> </button>";		
			
		}else if (_equiv(accion, ConstantesUtil.BTN_REGUSUARIO_SISTEMA)) {			
			icon = "fas fa-file";
			metodo = "registarUsuarioSistema";	
			
			return "<button  title='"
			+ accion
			+ "' class='btn waves-effect waves-light btn-rounded btn-info' onclick=\""
			+ metodo + "('" + id + "')\"><i class='" + icon
			+ "'></i> </button>";		
			
		}else {
			return "";
		}		
	}




}
