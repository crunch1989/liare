package com.stevens.liare.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechasUtil {


	public static Date sumarDiasAFecha(Date fecha, int dias){
		if (dias==0) return fecha;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); 	    
		calendar.add(Calendar.YEAR, dias);
		return calendar.getTime(); 
	}	


	public static String convertDateToString(Date fecha){
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");	 
		String fechaString ="";
		try {			
			fechaString = formatoDelTexto.format(fecha);		    
		} catch (Exception e) {			
		}	
		return fechaString;
	}

	public static String convertDateToString(Date fecha,String formato){
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato);	 
		String fechaString ="";
		try {			
			fechaString = formatoDelTexto.format(fecha);		    
		} catch (Exception e) {			
		}	
		return fechaString;
	}

	public static String convertDateToStringFechaFile(Date fecha){
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyyMMdd");	 
		String fechaString ="";
		try {			
			fechaString = formatoDelTexto.format(fecha);		    
		} catch (Exception e) {			
		}	
		return fechaString;
	}


	public static Date getToDay() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		format.setCalendar(cal);
		return cal.getTime();
	}
	
	public static Date getToFullDay() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		format.setCalendar(cal);
		return cal.getTime();
	}


	public static Date convertirCadenaAFecha(String fecha, String formato) {
		SimpleDateFormat format = new SimpleDateFormat(formato);
		try {
			return format.parse(fecha);
		} catch (ParseException e) {			
		}
		return null;
	}

	public static String convertirFechaACadena(Date fecha, String formato){
		if(estaVacio(fecha)){
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(formato);
		return format.format(fecha);
	}
	

	public static boolean estaVacio(Object object) {
		return StringUtil.isEmpty(object);
	}


}
