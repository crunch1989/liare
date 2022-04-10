package com.stevens.liare.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stevens.liare.controller.response.Response;
import com.stevens.liare.entity.Archivo;
import com.stevens.liare.entity.CategoriaEntity;
import com.stevens.liare.entity.ListarArchivo;
import com.stevens.liare.repository.ArchivoRepository;
import com.stevens.liare.repository.CatalogoRepository;
import com.stevens.liare.service.CargarArchivoService;
import com.stevens.liare.service.CatalogoService;
import com.stevens.liare.service.ListaArchivoService;
import com.stevens.liare.util.UploadUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	private Logger logger = LoggerFactory.getLogger(CategoriaController.class);	
	
	@Autowired
	private CatalogoService service;
	
	@Autowired
	private CatalogoRepository catalogo;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ArchivoRepository archirepository;
	
	@Autowired
	private CargarArchivoService cargarArchivoser;
	
	@Autowired
	private ListaArchivoService listararchivoservice;
	
	
	
	
	@GetMapping("listarCategoria")
	public String listar(Model model)throws Exception  {
	
		List<ListarArchivo> listararchivo = new ArrayList<ListarArchivo>();
		listararchivo = listararchivoservice.listarArchivo();
		
		
		CategoriaEntity categoria = new CategoriaEntity();
		model.addAttribute("cat", categoria);
		
		List<ListarArchivo> listnew = new ArrayList<ListarArchivo>();
		
		
		for (ListarArchivo categoriaEntity : listararchivo) {
				
			ListarArchivo newobj = new ListarArchivo();
			
				newobj.setIdcategoria(categoriaEntity.getIdcategoria());
				newobj.setItems(categoriaEntity.getItems());
				newobj.setNombreCategoria(categoriaEntity.getNombreCategoria());
				newobj.setRutaArchivo(categoriaEntity.getRutaArchivo());
				newobj.setIdarchivo(categoriaEntity.getIdarchivo());
				listnew.add(newobj);
				
			}
		
		model.addAttribute("listararchivo", listnew);
		
		return "app/categoria/listCategoria :: fragCategoria";
	}
	
	
	@ResponseBody
	@PostMapping(value="/guardar")
	public Response guardar(@ModelAttribute CategoriaEntity categoria, Locale locale, MultipartFile[] archivo) {
		
		
		
		 
		long rpta= service.guardarCategoria(categoria);
		  
		  
		
	
			//hacer if con categoria.getidrelacion
		
			
	
		
		  
		  for (int i = 0; i < archivo.length; i++) {
		  	int x = i;
		  	String base = "CATEGORIA";
			String nombrearchivo = UploadUtility.RenombrarArchivo(archivo, x, archivo[i].getOriginalFilename());
			String nombre = base + "_" + nombrearchivo;
		
			
			if(archivo[i].getSize()!= 0) {
			
				  
				  Archivo ar = new Archivo();
				  	ar.setNombrearchivo(nombre);
					ar.setTiporelacion("CATEGORIA");
					ar.setIdrelacion(rpta); 
					//ar.setPatharchivo(patharchivo);
					ar.setTamanioarchivo(archivo[i].getSize());
					ar.setEstado(1);
					
					long rp = cargarArchivoser.guardarArchivo(ar);
					
					//long rp  = ar.getIdarchivo();
					
					
			String patharchivo = "";

			String rutaservidor = UploadUtility.obtenerRutaServidorArchivo();
			patharchivo = rutaservidor + System.getProperty("file.separator") + base
					+ System.getProperty("file.separator") + rp + System.getProperty("file.separator") + nombre;
			
			 System.out.println(patharchivo+" "+"Adentro");
			 
			 Archivo are = new Archivo();
			 	are.setIdarchivo(rp);
			  	are.setNombrearchivo(nombre);
				are.setTiporelacion("CATEGORIA");
				are.setIdrelacion(rpta); 
				are.setPatharchivo(patharchivo);
				are.setTamanioarchivo(archivo[i].getSize());
				are.setEstado(1);
				
				long rpid = cargarArchivoser.guardarArchivo(are);
		
			
				System.out.println(rpid+"RPPPPPPP");
				boolean rpt = false;
				rpt = cargarArchivoser.CargarArchivo(archivo, x, rp, "CATEGORIA", nombre);
				
				logger.info("respuesta==========*filearchivo*"+rpt);
				
				CategoriaEntity cat = new CategoriaEntity();
				cat.setId_categoria(rpta);
				cat.setNombre_categoria(categoria.getNombre_categoria());
				cat.setEstado(1);
				cat.setIdtbarchivo(are.getIdarchivo());
				long rptas= service.guardarCategoria(cat);
				System.out.println(rptas+"datos");
				
				
		  }
		}
		
		  System.out.println("Adentro");
		  return new Response("Done",messageSource.getMessage("text.usuario.mensaje.ok", null, locale));
		
	
	}
	
	
	@GetMapping("/editar-categoria/{id}/{idarchivo}")
	public String editarCategoria(@PathVariable("id") Long id,@PathVariable("idarchivo") Long idarchivo, Model model){
		
		System.out.println("controller editar categoria");

		List<ListarArchivo> listararchivo = new ArrayList<ListarArchivo>();
		listararchivo = listararchivoservice.listarArchivo();
		
		
		CategoriaEntity categoria = new CategoriaEntity();
		model.addAttribute("cat", categoria);
		
		List<ListarArchivo> listnew = new ArrayList<ListarArchivo>();
		
		
		for (ListarArchivo categoriaEntity : listararchivo) {
				
			ListarArchivo newobj = new ListarArchivo();
			
				newobj.setIdcategoria(categoriaEntity.getIdcategoria());
				newobj.setItems(categoriaEntity.getItems());
				newobj.setNombreCategoria(categoriaEntity.getNombreCategoria());
				newobj.setRutaArchivo(categoriaEntity.getRutaArchivo());
				newobj.setIdarchivo(categoriaEntity.getIdarchivo());
				listnew.add(newobj);
				
			}
		
		model.addAttribute("listararchivo", listnew);
		CategoriaEntity cat = service.categoryEntity(id);
		
		model.addAttribute("cat", cat);
		
		
	
		
		
		
		return "app/categoria/listCategoria :: fragCategoria";
	}

}
