package com.stevens.liare.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.stevens.liare.base.JpaGenericRepository;
import com.stevens.liare.dao.UsuarioDao;
import com.stevens.liare.dto.FiltroUsuarioDTO;
import com.stevens.liare.dto.PaginacionDTO;
import com.stevens.liare.model.ListarUsuarioModel;
import com.stevens.liare.model.TotalRegistrosModel;


@Repository("usuarioDao")
public class UsuarioDaoImpl extends JpaGenericRepository implements UsuarioDao{

	private Logger logger = LoggerFactory.getLogger(UsuarioDaoImpl.class);			
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> filtroUsuarios(PaginacionDTO paginacion ,FiltroUsuarioDTO filtroBusqDTO) {

		
		Map<String, Object> mapFiltro = new HashMap<String, Object>();
		
		List<ListarUsuarioModel> listaFiltro = new ArrayList<ListarUsuarioModel>();
		
		Long total = new Long(0);	
		
		try {

			StoredProcedureQuery storedProcedureQuery = createEntityManager().createStoredProcedureQuery("SRHMINT.PKG_BASE.LISTAR_USUARIOS",ListarUsuarioModel.class);

			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);	
			
			storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);  				
			
			storedProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);

			// Configuramos el valor de entrada		
			storedProcedureQuery.setParameter(2, paginacion.getiDisplayStart()!=null?
					paginacion.getiDisplayStart():0);			
			storedProcedureQuery.setParameter(3, paginacion.getiDisplayLength()!=null?
					paginacion.getiDisplayLength():0);	
			storedProcedureQuery.setParameter(4, StringUtils.isNotBlank(filtroBusqDTO.getTextoBusqueda())?filtroBusqDTO.getTextoBusqueda():"");
			storedProcedureQuery.setParameter(5, StringUtils.isNotBlank(filtroBusqDTO.getDni())?filtroBusqDTO.getDni():"");
			storedProcedureQuery.setParameter(6, StringUtils.isNotBlank(filtroBusqDTO.getApellidoPaterno())?filtroBusqDTO.getApellidoPaterno():"");
			storedProcedureQuery.setParameter(7, StringUtils.isNotBlank(filtroBusqDTO.getApellidoMaterno())?filtroBusqDTO.getApellidoMaterno():"");
			storedProcedureQuery.setParameter(8, StringUtils.isNotBlank(filtroBusqDTO.getNombres())?filtroBusqDTO.getNombres():"");

			// Realizamos la llamada al procedimiento
			storedProcedureQuery.execute();		

			listaFiltro =  (List<ListarUsuarioModel>)storedProcedureQuery.getResultList();
			
			logger.info("tamanio de la lista ==="+listaFiltro.size());
			
			total = this.obtenerTotalRegistros(filtroBusqDTO);

		} catch (Exception e) {
			e.printStackTrace();			
		}
		mapFiltro.put("total", total);
		mapFiltro.put("listaFiltroUsuarios", listaFiltro);
		
		return mapFiltro;
	}
	
	
	private Long obtenerTotalRegistros(FiltroUsuarioDTO filtroBusqDTO) {
		
		Long total = new Long(0);
		
		try {

			StoredProcedureQuery storedProcedureQuery = createEntityManager().createStoredProcedureQuery("SRHMINT.PKG_BASE.TOTAL_LISTAR_USUARIOS",TotalRegistrosModel.class);

			// Registrar los parámetros de entrada y salida
			storedProcedureQuery.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);	
			
			storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
			
			storedProcedureQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);

			// Configuramos el valor de entrada		
			storedProcedureQuery.setParameter(2, StringUtils.isNotBlank(filtroBusqDTO.getTextoBusqueda())?filtroBusqDTO.getTextoBusqueda():"");
			storedProcedureQuery.setParameter(3, StringUtils.isNotBlank(filtroBusqDTO.getDni())?filtroBusqDTO.getDni():"");
			storedProcedureQuery.setParameter(4, StringUtils.isNotBlank(filtroBusqDTO.getApellidoPaterno())?filtroBusqDTO.getApellidoPaterno():"");
			storedProcedureQuery.setParameter(5, StringUtils.isNotBlank(filtroBusqDTO.getApellidoMaterno())?filtroBusqDTO.getApellidoMaterno():"");
			storedProcedureQuery.setParameter(6, StringUtils.isNotBlank(filtroBusqDTO.getNombres())?filtroBusqDTO.getNombres():"");

			// Realizamos la llamada al procedimiento
			storedProcedureQuery.execute();		

			TotalRegistrosModel totalModel =  (TotalRegistrosModel)storedProcedureQuery.getSingleResult();	
			
			total = totalModel.getTotalRegistros();
			
			logger.info("total registros==="+total);

		} catch (Exception e) {
			e.printStackTrace();			
		}	
		
		return total;
		
	}
		

	
	
	

}
