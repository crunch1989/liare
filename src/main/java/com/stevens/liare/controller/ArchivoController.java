package com.stevens.liare.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stevens.liare.entity.Archivo;
import com.stevens.liare.entity.ListarArchivo;
import com.stevens.liare.service.CargarArchivoService;
import com.stevens.liare.service.ListaArchivoService;
@Controller
@RequestMapping("archivo")
public class ArchivoController {

	@Autowired
	private CargarArchivoService listararchivoservice;
	
	@Autowired
	private ListaArchivoService descargar;
	
	@GetMapping("download/{idcategoria}")
	public void donwloadFile(@PathVariable Long idcategoria, HttpServletResponse response) throws IOException {
		
		String ruta ="";
		Archivo archivo = listararchivoservice.obtenerArchivoID(idcategoria);
		System.out.println(archivo);
		ruta = archivo.getPatharchivo();
		descargar.download(ruta, response);
		return;//sin el return tambien funciona ya que void no retorna nada
	}
	
}
