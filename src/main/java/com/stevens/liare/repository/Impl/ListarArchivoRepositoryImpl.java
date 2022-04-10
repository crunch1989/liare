package com.stevens.liare.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.stevens.liare.base.JpaGenericRepository;
import com.stevens.liare.entity.ListarArchivo;
import com.stevens.liare.repository.ListarArchivoRepository;

@Repository
public class ListarArchivoRepositoryImpl extends JpaGenericRepository implements ListarArchivoRepository{

	@SuppressWarnings("unchecked")
	@Override
	public List<ListarArchivo> listarArchivo() {
		StoredProcedureQuery storedProcedureQuery = createEntityManager()
				.createStoredProcedureQuery("SYSTEM.PKG_BASE.LISTARCATEGORIA", ListarArchivo.class);
       
		storedProcedureQuery.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);
		
		storedProcedureQuery.execute();
		List<ListarArchivo> lista = new ArrayList<ListarArchivo>();
		
		lista = storedProcedureQuery.getResultList();

		return lista;
	}

	
	
}
