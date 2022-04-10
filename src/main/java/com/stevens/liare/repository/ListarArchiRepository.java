package com.stevens.liare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stevens.liare.entity.ListarArchivo;

@Repository
public interface ListarArchiRepository extends JpaRepository<ListarArchivo, Long>{

}
