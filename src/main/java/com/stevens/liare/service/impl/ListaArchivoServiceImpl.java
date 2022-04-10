package com.stevens.liare.service.impl;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.util.FileCopyUtils;

import com.stevens.liare.entity.ListarArchivo;
import com.stevens.liare.repository.ArchivoRepository;

import com.stevens.liare.repository.ListarArchivoRepository;
import com.stevens.liare.service.ListaArchivoService;


@Service
@Transactional
public class ListaArchivoServiceImpl implements ListaArchivoService{

	private Logger logger = LoggerFactory.getLogger(ListaArchivoServiceImpl.class);	
	@Autowired
	private ListarArchivoRepository repository;
	@Autowired
	private ArchivoRepository listarepository;
	
	
	@Override
	public List<ListarArchivo> listarArchivo() {
		
		return repository.listarArchivo();
	}

	@Override
	public void download(String fileName, HttpServletResponse response)throws IOException {
	   
		try {

		/*
			String patharchivo = "";

			String rutaservidor = UploadUtility.obtenerRutaServidorArchivo();
			patharchivo = rutaservidor + System.getProperty("file.separator") + base
					+ System.getProperty("file.separator") + ids + System.getProperty("file.separator") + idn;
*/
			String nombreArchivoDescarga = "ok";
			boolean descargaArchivo = true;
			descargaArchivo = true;
			

			if (descargaArchivo) {
				File fileToDownload = new File(fileName);
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileToDownload));
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivoDescarga + "\"");
				FileCopyUtils.copy(in, response.getOutputStream());
				response.getOutputStream().flush();
				response.getOutputStream().close();

			} else {
				return;
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			response.sendRedirect("/liare/categoria/listarCategoria");
		}
}

	
}
