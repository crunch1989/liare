package com.stevens.liare.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stevens.liare.security.model.RolesUsuario;
import com.stevens.liare.security.model.Usuario;
import com.stevens.liare.security.repository.LoginUserDao;
import com.stevens.liare.util.ConstantesUtil;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	LoginUserDao loginUserDao;	
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
			
		Usuario usu = loginUserDao.loginUsuario(username);		
		
		logger.info("logeo usuario ======"+usu); 
		
		if(usu == null) {			
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}

		//si el usuario si existe y esta activo obtenemos sus roles


		List<RolesUsuario> authorities = loginUserDao.rolesByUser(usu.getIdUsuario(),
				ConstantesUtil.CODIGO_SISTEMA);

		
		if(authorities.isEmpty()) {			
			throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
		}
		
		usu.setRoles(authorities); 		

		return UserPrincipal.build(usu);
	}
	
}