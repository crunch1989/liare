package com.stevens.liare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stevens.liare.entity.Archivo;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long>{
	
	public List<Archivo> findAll();

}
