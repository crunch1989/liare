package com.stevens.liare.repository.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.stevens.liare.repository.CargarArchivoRepository;
import com.stevens.liare.util.UploadUtility;
import com.stevens.liare.util.UploadedFile;

@Repository
public class CargarArchivoRepositoryImpl implements CargarArchivoRepository {

	@Override
	public boolean CargarArchivo(MultipartFile[] archivo, Integer x, Long idBase, String tipoProceso,
			String nombre) {
		UploadedFile uploadFile = new UploadedFile();

		uploadFile.setFile(archivo[x]);
		uploadFile.setIdbase(idBase);
		uploadFile.setProceso(tipoProceso);
		uploadFile.setName(nombre);

		uploadFile.setLength(archivo.length);
		uploadFile.setTipodocumento(archivo[x].toString());

		try {
			uploadFile.setBytes(archivo[x].getBytes());
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		uploadFile.setTipodocumento(archivo[x].getName());
		try {

			System.out.println(archivo[x].getBytes());
			UploadUtility.saveUploadedFileToDisk(uploadFile);

		} catch (Exception e) {
			return false;
		}

		System.out.println(archivo[x].getOriginalFilename());

		return true;
	}

}
