package com.stevens.liare.dao;

import java.util.Map;

import com.stevens.liare.dto.FiltroUsuarioDTO;
import com.stevens.liare.dto.PaginacionDTO;

public interface UsuarioDao {	

	
	public Map<String, Object> filtroUsuarios(PaginacionDTO paginacion , 
			FiltroUsuarioDTO filtroBusqDTO);
	
	
	

}
