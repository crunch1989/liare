package com.stevens.liare.controller.response;

public class Response {
	
	private String status;
	private Object data;
	private Long id;
	
	public Response(){
		
	}
	
	public Response(String status, Object data){
		this.status = status;
		this.data = data;
	} 
	
	public Response(String status, Object data, Long id){
		this.status = status;
		this.data = data;
		this.id = id;
	} 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}
 
	public void setData(Object data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
