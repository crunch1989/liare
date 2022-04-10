package com.stevens.liare.security.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.stevens.liare.base.JpaGenericRepository;
import com.stevens.liare.security.model.RolesUsuario;
import com.stevens.liare.security.model.Usuario;
import com.stevens.liare.security.repository.LoginUserDao;


@Repository
public class LoginUserDaoImpl extends JpaGenericRepository implements LoginUserDao{

	private Logger logger = LoggerFactory.getLogger(LoginUserDaoImpl.class);	
		
	
	@Override	
	public Usuario loginUsuario(String username) {
		
		logger.info("username    "+username);
		try {
						
			StoredProcedureQuery storedProcedureQuery = createEntityManager().
					createStoredProcedureQuery("PKG_BASE.LOGIN_USUARIO",Usuario.class);
	        
	        // Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);
	        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);     	       
	 
	        // Configuramos el valor de entrada
	        storedProcedureQuery.setParameter(2, username);
	 
	        // Realizamos la llamada al procedimiento
	        storedProcedureQuery.execute();		
	        
	       
	        return (Usuario)storedProcedureQuery.getSingleResult();								
			
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
			
	}
	
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<RolesUsuario> rolesByUser(Long idUsario, String codigoSistema) {	
			
		
		
		StoredProcedureQuery storedProcedureQuery = createEntityManager().
				createStoredProcedureQuery("PKG_BASE.ROLES_USUARIO",RolesUsuario.class);
        
        // Registrar los parámetros de entrada y salida
		storedProcedureQuery.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);
        storedProcedureQuery.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);    
        storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);    
 
        // Configuramos el valor de entrada
        storedProcedureQuery.setParameter(2, idUsario);
        storedProcedureQuery.setParameter(3, codigoSistema);
 
        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();	
        
		List<RolesUsuario> lista = new ArrayList<RolesUsuario>();
		
		lista = storedProcedureQuery.getResultList();

		return lista;	
	}


}
