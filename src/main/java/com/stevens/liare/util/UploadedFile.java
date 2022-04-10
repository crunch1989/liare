package com.stevens.liare.util;



import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {
	
	private int length;
	
    private byte[] bytes;
    
    private String name;
    
    private String type;
    
    private MultipartFile file;
    
    private String proceso;
    
    private String tipodocumento;
    
    private Long idbase;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}




	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Long getIdbase() {
		return idbase;
	}

	public void setIdbase(Long idbase) {
		this.idbase = idbase;
	}

	
    
    
    
    
    
	

}
