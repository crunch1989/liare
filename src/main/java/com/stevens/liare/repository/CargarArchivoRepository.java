package com.stevens.liare.repository;

import org.springframework.web.multipart.MultipartFile;

public interface CargarArchivoRepository {

	public boolean CargarArchivo(MultipartFile[] archivo,Integer x,Long idBase,String tipoProceso,String nombre);
}
