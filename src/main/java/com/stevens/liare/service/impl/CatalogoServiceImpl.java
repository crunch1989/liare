package com.stevens.liare.service.impl;




import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stevens.liare.entity.CategoriaEntity;
import com.stevens.liare.repository.CatalogoRepository;
import com.stevens.liare.service.CatalogoService;




@Service
public class CatalogoServiceImpl implements CatalogoService {

	@Autowired
	private CatalogoRepository repository;
	
	@Override
	public List<CategoriaEntity> findAll() {
	
		return repository.findAll();
	}

	@Override
	public Page<CategoriaEntity> listar(Pageable pageable) {
		  return repository.findAll(pageable);
	}

	@Override
	public Long guardarCategoria(CategoriaEntity categoria) {
		Long rpta =0L;
		
		CategoriaEntity cat= null;
		
		if(categoria.getId_categoria()!=0 && categoria!=null ) {
			cat=repository.findById(categoria.getId_categoria()).orElse(null);
			if(cat!=null) {
				//actualización
				cat.setNombre_categoria(categoria.getNombre_categoria());
				cat.setEstado(1);
				cat.setIdtbarchivo(categoria.getIdtbarchivo());
				
				repository.save(cat);
				rpta = cat.getId_categoria();
				
			}
			
		}else {
			//nuevo
			
			cat = new CategoriaEntity();
			cat.setId_categoria(categoria.getId_categoria());
			cat.setNombre_categoria(categoria.getNombre_categoria());
			cat.setEstado(1);
			cat.setIdtbarchivo(0);
			repository.save(cat);
			rpta = cat.getId_categoria();
		}
		return rpta;
	}

	@Override
	public CategoriaEntity categoryEntity(Long id) {
		
		CategoriaEntity cat = new CategoriaEntity();
		CategoriaEntity cate = repository.findById(id).orElse(null);
		
		BeanUtils.copyProperties(cate, cat);
				
		
		return cat;
	}

}
