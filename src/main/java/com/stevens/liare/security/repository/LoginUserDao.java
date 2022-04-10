package com.stevens.liare.security.repository;

import java.util.List;

import com.stevens.liare.security.model.RolesUsuario;
import com.stevens.liare.security.model.Usuario;

public interface LoginUserDao {
	
	public Usuario loginUsuario(String username);
	
	public List<RolesUsuario> rolesByUser(Long idUsario, String codigoSistema);

}
