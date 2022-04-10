package com.stevens.liare.util;



import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

public class UploadUtility {

	private static final String SERVIDOR_ARCHIVO_LINUX="/opt/rondascampesinas";
	private static final String SERVIDOR_ARCHIVO_WINDOWS="C:\\Tomcat\\srvArchivo";
	
	
	
	
	public static boolean isEmptyFile(MultipartFile mpf ){
		
		if(mpf==null || (mpf!=null && (mpf.getSize()==0 )  ) ){
			return true;
		}		
		return false;
	}		
			
	public static  MultipartFile getMultipartFileFromRequest(MultipartHttpServletRequest request){
		
		Iterator<String> itr = request.getFileNames();
		
				
		MultipartFile mpf = request.getFile(itr.next());
		
		return mpf;
	}
	
	public static  List<MultipartFile> getLstMultipartFileFromRequest(MultipartHttpServletRequest request){
		Iterator<String> itr = request.getFileNames();		
		List<MultipartFile> lst = new ArrayList<MultipartFile>();
				
		 while (itr.hasNext()) {  
			 //MultipartFile mpf = request.getFile(itr.next());  
			 lst.add(request.getFile(itr.next()));
		   }  
		
		
		
		return lst;
	}
	
	
    public static void saveUploadedFileToDisk(UploadedFile uploadedFile) throws Exception {
    	
    	
    	String extension = FilenameUtils.getExtension(uploadedFile.getFile().getOriginalFilename());
    	
    	if(!verificarExtension(uploadedFile.getTipodocumento(),extension)){    		
    		throw new Exception("forms.errors.upload.extension");    		
    	}
    	   	  	
        File dir = new File(UploadUtility.calculateDestinationDirectory(uploadedFile.getIdbase(),uploadedFile.getProceso()));
        if(!dir.exists()) {
            dir.mkdirs();
        }
        File multipartFile = new File(UploadUtility.calculateDestinationPath(uploadedFile));//ruta destino
         FileOutputStream fs;
    	byte[] stream = uploadedFile.getBytes();
    	
        BufferedOutputStream bs = null;
			File localFile=multipartFile;
			//logger.info("ingresando a guardar adjuntos e las visitas"); 
			fs = new FileOutputStream(localFile.getPath() + getSeparator() + uploadedFile.getName());//esto busca
			bs = new BufferedOutputStream(fs);
	try {

			bs.write(stream);
			bs.close();						
		} catch (IOException e1) {
	
			e1.printStackTrace();
		}

		bs = null;
        
        
        
    }
      

    
    public static boolean verificarExtension(String td,String extension){
		boolean resultado=false;			
			if(extension.toUpperCase().equals("PDF"))
				resultado= true;	
			else if(extension.toUpperCase().equals("XLS"))
				resultado= true;
			else if(extension.toUpperCase().equals("XLSX"))
				resultado= true;
			else if(extension.toUpperCase().equals("JPG"))
				resultado= true;
			else if(extension.toUpperCase().equals("JPEG"))
				resultado= true;
			else if(extension.toUpperCase().equals("PNG"))
				resultado= true;
			else if(extension.toUpperCase().equals("DOC"))
				resultado= true;
			else if(extension.toUpperCase().equals("DOCX"))
				resultado= true;
			else 
				resultado= false;	
		
		return resultado;
	}
    
    
	
 private  static String calculateDestinationPath(UploadedFile uploadedFile) {
    	
    	  String result = calculateDestinationDirectory(uploadedFile.getIdbase(),uploadedFile.getProceso());
       //   result +=getSeparator();
          
        return result;
    }
    
    

    private static String calculateDestinationDirectory(Long idCedula,String proceso) {
        String result = UploadUtility.obtenerRutaServidorArchivo();
        result +=getSeparator();
        if(!Utilidades.toStr(proceso).equals("")){
            result += proceso;
            result += getSeparator();
        } 
        
        if(!Utilidades.toStr(idCedula).equals("")){
            result += idCedula;
            result += getSeparator();
        }
                    
            
        return result;
    }
	
  
	public static String getSeparator(){
		return System.getProperty("file.separator");
	}
	
	
	public static String obtenerRutaServidorArchivo(){
		String separador = System.getProperty("file.separator");
		if(separador.equals("/")) // Linux (/)
			return SERVIDOR_ARCHIVO_LINUX;
		else // Windows (\)
			return SERVIDOR_ARCHIVO_WINDOWS;
	}
	
	public static String obtenerSO(){
		String separador = System.getProperty("file.separator");
		if(separador.equals("/")) // Linux (/)
			return "LINUX";
		else // Windows (\)
			return "WINDOWS";
	}
	
	
    
    public static void saveFileToDiskArchivoSustento(UploadedFile uploadedFile) throws Exception {    
     		
         File dir = new File(UploadUtility.calculateDestinationDirectoryArchivo(uploadedFile.getIdbase()));
         
         if(!dir.exists()) {
             dir.mkdirs();
         }
         
         File multipartFile = new File(UploadUtility.calculateDestinationPathArchivo(uploadedFile));
         
         uploadedFile.getFile().transferTo(multipartFile);
     }
   

    private static String calculateDestinationDirectoryArchivo(Long idCedula) {
       String result = UploadUtility.obtenerRutaServidorArchivo();
       String separador = System.getProperty("file.separator");
 	  if(separador.equals("/")){ // Linux (/)
 		  result+="/CEDULA";
 	  }else{
 		  result+="\\CEDULA";  
 	  }
       result +=getSeparator();
       if(!Utilidades.toStr(idCedula).equals("")){
           result += idCedula;
           result += getSeparator();
       }     
       return result;
    }   
    
    private  static String calculateDestinationPathArchivo(UploadedFile uploadedFile) {   	
 	      	
 	   String result = calculateDestinationDirectoryArchivo(uploadedFile.getIdbase());

 	   result +=getSeparator();

 	   result += uploadedFile.getIdbase()+"."+FilenameUtils.getExtension(uploadedFile.getFile().getOriginalFilename());
 	  // uploadedFile.setName(uploadedFile.getIdPersona()+"_"+sFechaHora+"."+FilenameUtils.getExtension(uploadedFile.getFile().getOriginalFilename()));

 	   return result;
    }
    
    public static boolean isValidFile(MultipartFile mpf ){
		
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("PDF")){
 			return true;
 		}	
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("XLS")){
 			return true;
 		}
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("XLSX")){
 			return true;
 		}
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("JPG")){
 			return true;
 		}
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("PNG")){
 			return true;
 		}
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("DOC")){
 			return true;
 		}
 		if(mpf!=null && mpf.getSize()!=0 && !Utilidades.toStr(mpf.getOriginalFilename()).equals("") && FilenameUtils.getExtension(mpf.getOriginalFilename().toUpperCase()).equals("DOCX")){
 			return true;
 		}
 		return false;
 	}
    
    public static String RenombrarArchivo(MultipartFile[] archivo, Integer x, String tipoProceso) {
		
		Date hoy = new Date();
   	 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	     String sFechaHora = formatter.format(hoy);	
	     String nombrearchivo="";
	     
		
			
	     		
	     			UploadedFile uploadFile = new UploadedFile();
					uploadFile.setFile(archivo[x]);
					//uploadFile.setIdcedula(idCedula);
					uploadFile.setProceso(tipoProceso);
					uploadFile.setName(sFechaHora+"."+FilenameUtils.getExtension(uploadFile.getFile().getOriginalFilename()));			       
					nombrearchivo=uploadFile.getName();
					
			
				
		
		return nombrearchivo;
	}
   

}
