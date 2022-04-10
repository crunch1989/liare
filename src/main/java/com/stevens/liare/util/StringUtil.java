package com.stevens.liare.util;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StringUtil {	

	public static boolean isEmpty(String obj) {
		return ((obj == null) || (obj.trim().length() == 0));
	}


	// Metodo convierte una cadena a long.   
	public static Long toLong(Object objeto) {
		if (isEmpty(objeto)) {
			return null;
		}
		try {
			return Long.parseLong(objeto.toString());
		} catch (NumberFormatException e) {			
			return null;
		}
	}

	//Metodo convierte una cadena a short.
	public static Short toShort(Object objeto) {
		if (isEmpty( objeto )) {
			return null;
		}
		try {
			return Short.parseShort( objeto.toString() );
		} catch (NumberFormatException e) {			
			return null;
		}
	}

	//Metodo convierte una cadena a integer.
	public static Integer toInteger(Object objeto) {
		if (isEmpty(objeto)) {
			return null;
		}
		try {
			return Integer.parseInt(objeto.toString());
		} catch (NumberFormatException e) {			
			return null;
		}
	}

	//Metodo convierte una cadena a double.
	public static Double toDouble(Object objeto) {
		if (isEmpty(objeto)) {
			return null;
		}
		try {
			return Double.parseDouble(objeto.toString());
		} catch (NumberFormatException e) {			
			return null;
		}
	}

	//Metodo convierte una cadena a float.
	public static Float toFloat(Object objeto) {
		if (isEmpty(objeto)) {
			return null;
		}
		try {
			return Float.parseFloat(objeto.toString());
		} catch (NumberFormatException e) {			
			return null;
		}
	}

	//Metodo convierte un objeto a cadena
	public static String toStr(Object cadena) {
		return isEmpty(cadena) ? null : toBlank(cadena.toString());
	}

	// Metodo devuelve una cadena formateada.
	public static String toBlank(String cadena) {
		return isEmpty(cadena) ? "" : cadena;
	}

	// Metodo devuelve una cadena, cadena vacia si el objeto es null (uso para grilla)
	public static String toBlankObject(Object object) {
		return isEmpty(object) ? "" : object.toString();
	}

	//Verifica si un objecto es vacio: 
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return object.toString().trim().length() == 0;
		}
		if (object instanceof StringBuilder) {
			return object.toString().trim().length() == 0;
		}
		if (object instanceof List<?> || object instanceof ArrayList<?>) {
			return ((List<?>) object).isEmpty();
		}
		if (object instanceof Map<?, ?> || object instanceof HashMap<?, ?>) {
			return ((Map<?, ?>) object).isEmpty();
		}
		return false;
	}

	//Compara si el valor de dos objetos es igual
	public static boolean equiv(Object object1, Object object2) {
		if (isEmpty(object1) && !isEmpty(object2) || !isEmpty(object1) && isEmpty(object2)) {
			return false;
		}
		if (isEmpty(object1) && isEmpty(object2) || object1 == object2) {
			return true;
		}

		if (object1 instanceof String && object2 instanceof String) {
			return toBlank(object1.toString()).equals(toBlank(object2.toString()));
		}
		return object1.equals(object2);
	}

	//Metodo busca una cadena en una arreglo de cadenas.
	public static boolean inList(String cadena, String... valores) {
		for (String valor : valores) {
			if (cadena.equals(valor)) {
				return true;
			}
		}
		return false;
	}
	

	public static String decodificarConUTF8(String valor) throws Exception {
		String valorDecodificado;
		if (valor != null && valor != "") {
			valorDecodificado = URLDecoder.decode(valor, "UTF-8");	
		}
		else {
			valorDecodificado = valor;
		}	

		return valorDecodificado;
	}
}
