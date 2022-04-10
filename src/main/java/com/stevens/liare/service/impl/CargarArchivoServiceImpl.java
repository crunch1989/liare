package com.stevens.liare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stevens.liare.entity.Archivo;

import com.stevens.liare.repository.ArchivoRepository;
import com.stevens.liare.repository.CargarArchivoRepository;
import com.stevens.liare.service.CargarArchivoService;
import org.springframework.beans.BeanUtils;

@Service
public class CargarArchivoServiceImpl implements CargarArchivoService {
	
	@Autowired
	private CargarArchivoRepository cargarArchivoRepository;
	
	@Autowired
	private ArchivoRepository archirepository;

	@Override
	public boolean CargarArchivo(MultipartFile[] archivo, Integer x, Long idBase, String tipoProceso,
			String nombre) {
		return cargarArchivoRepository.CargarArchivo(archivo, x, idBase, tipoProceso,nombre);
	}

	@Override
	public Long guardarArchivo(Archivo archivo) {
	
				
		Long rpta = 0L;

		Archivo arch= null;
		
		if(archivo.getIdarchivo()!=0 && archivo!=null) {
			arch= archirepository.findById(archivo.getIdarchivo()).orElse(null);
			if(arch!=null) {
				//actualizamos
				arch.setTiporelacion(archivo.getTiporelacion());
				arch.setIdrelacion(archivo.getIdrelacion());
				arch.setNombrearchivo(archivo.getNombrearchivo());
				arch.setPatharchivo(archivo.getPatharchivo());
				arch.setTamanioarchivo(archivo.getTamanioarchivo());
				arch.setArchivoadj(archivo.getArchivoadj());
				arch.setEstado(1);
				
				archirepository.save(arch);
				
				rpta=arch.getIdarchivo();
				
				
				
				
			}
					
			
			
			
		}else {
			//nuevo
			arch = new Archivo();
			arch.setIdarchivo(archivo.getIdarchivo());
			arch.setTiporelacion(archivo.getTiporelacion());
			arch.setIdrelacion(archivo.getIdrelacion());
			arch.setNombrearchivo(archivo.getNombrearchivo());
			arch.setPatharchivo(archivo.getPatharchivo());
			arch.setTamanioarchivo(archivo.getTamanioarchivo());
			arch.setArchivoadj(archivo.getArchivoadj());
			arch.setEstado(1);
			
			archirepository.save(arch);
			
			rpta=arch.getIdarchivo();
		}
		
		
			return rpta;
	}

	@Override
	public Archivo obtenerArchivoID(Long id) {
		Archivo ronda = new Archivo();

		Archivo rondera = archirepository.findById(id).orElse(null);  	

		BeanUtils.copyProperties(rondera, ronda);
		
		return ronda;
	}


}
