package com.stevens.liare.service;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stevens.liare.entity.CategoriaEntity;




public interface CatalogoService{
	
	
	public List<CategoriaEntity> findAll();
	
	Page<CategoriaEntity> listar(Pageable pageable);
	
	Long guardarCategoria(CategoriaEntity categoria);
	
	CategoriaEntity categoryEntity(Long id);
	

}
