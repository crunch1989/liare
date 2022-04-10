package com.stevens.liare.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.stevens.liare.entity.ListarArchivo;

public interface ListaArchivoService {
	
	public List<ListarArchivo> listarArchivo();

	 public void download(String fileName, HttpServletResponse response)throws IOException;
	 
	
}
