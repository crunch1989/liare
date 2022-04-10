package com.stevens.liare.service;

import org.springframework.web.multipart.MultipartFile;

import com.stevens.liare.entity.Archivo;
import com.stevens.liare.entity.ListarArchivo;

public interface CargarArchivoService {

	
	public boolean CargarArchivo(MultipartFile[] archivo,Integer x,Long idBase,String tipoProceso,String nombre);
	
	
	Long guardarArchivo (Archivo archivo);
	
	Archivo obtenerArchivoID(Long id);
	
	
	
	
	
	
	
}
