package com.stevens.liare.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stevens.liare.entity.CategoriaEntity;



@Repository
public interface CatalogoRepository extends JpaRepository<CategoriaEntity, Long> {

	public List<CategoriaEntity> findAll();
	
}
