package com.stevens.liare.util;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.Blob;
import java.sql.SQLException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.sql.rowset.serial.SerialBlob;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

public class Utilidades {


	public static String rellenarCeros(String valor, int cantidadCeros){

		String retorno=valor;

		for (int i = valor.length(); i < cantidadCeros; i++) {
			retorno =  ("0"+retorno);
		}

		return retorno;
	}

	public static String obtenerPath(String nombrefolder)
	{
		String filePath = new File("").getAbsolutePath()+File.separator; 
		File folder = new File(filePath+File.separator+nombrefolder);
		if (!folder.exists()) {
			folder.mkdir();	
		}
		return filePath+nombrefolder+File.separator;
	}

	public static String  determinarPosicionFirmaX(){

		return "205";
	}


	public static String  determinarPosicionFirmaY(){

		return "340";
	}

	public static String  determinarPosicionVoBoX(int contadorVoBo){

		if (contadorVoBo<7) return "5";
		else return "500";
	}
	public static String  determinarPosicionVoBoY(int contadorVoBo){

		if (contadorVoBo==0) {

			return Integer.toString(350);
		}
		else return Integer.toString(350+contadorVoBo*60);	
	}


	public static Map<String,String> listarAnios(Authentication authentication)
	{
		Map<String,String> anios = new HashMap<String,String> ();
		if(authentication!=null  ){

			Calendar cal= Calendar.getInstance();
			int year= cal.get(Calendar.YEAR);

			for(int val=2012; val<=year;val++){
				anios.put(val+"",val+""); 
			}

		} 
		return anios;
	}

	public static Blob  converterToBlob(MultipartFile documento)
	{
		SerialBlob sBlob;
		Blob blobValue=null;
		try {
			sBlob = new SerialBlob(documento.getBytes());
			blobValue = new SerialBlob(sBlob);
		} catch (IOException | SQLException e) {
			System.out.println("Ocurrio un error cuando se intentaba convertir el arreglo de bytes a Blob"+e.getMessage());
			e.printStackTrace();
		}
		return blobValue;
	}



	public static void writeToDisk(String filename, MultipartFile multipartFile)
	{
		try
		{
			//  String fullFileName = Configuration.getProperty("ImageDirectory") + filename;
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(multipartFile.getBytes());
			fos.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static  String obtenerMimeType (String extension){
		String mime="";

		if(extension.equals("doc")){
			mime="application/msword";
		}else  if(extension.equals("pdf") || extension.equals("PDF")){
			mime="application/pdf";
		}else  if(extension.equals("avi") || extension.equals("AVI")  ){
			mime="video/x-msvideo";
		}else  if(extension.equals("bz") || extension.equals("BZ")  ){
			mime="application/x-bzip";
		}else  if(extension.equals("csv") || extension.equals("CSV")){
			mime="text/csv";
		}else  if(extension.equals("gif") || extension.equals("GIF") ){
			mime="image/gif";
		}else  if(extension.equals("html") || extension.equals("htm")  ){
			mime="text/html";
		}else  if(extension.equals("ico") || extension.equals("ICO") ){
			mime="image/x-icon";
		}else  if(extension.equals("jpeg") || extension.equals("JPG") ){
			mime="image/jpeg";
		}else  if(extension.equals("mpeg") || extension.equals("MPEG")){
			mime="video/mpeg";
		}else  if(extension.equals("odp") || extension.equals("ODP") ){
			mime="application/vnd.oasis.opendocument.presentation";
		}else  if(extension.equals("ods") || extension.equals("ODS") ){
			mime="application/vnd.oasis.opendocument.spreadsheet";
		}else  if(extension.equals("odt") || extension.equals("ODT")){
			mime="application/vnd.oasis.opendocument.text";
		}else  if(extension.equals("ppt") || extension.equals("PPT")){
			mime="application/vnd.ms-powerpoint";
		}else  if(extension.equals("rar") || extension.equals("RAR")){
			mime="application/x-rar-compressed";
		}else  if(extension.equals("rtf") || extension.equals("RTF")){
			mime="application/rtf";
		}else  if(extension.equals("xls") || extension.equals("XLS") ){
			mime="application/vnd.ms-excel";
		}else  if(extension.equals("zip") || extension.equals("ZIP")){
			mime="application/zip";
		}else  if(extension.equals("7z") || extension.equals("7Z") ){
			mime="application/x-7z-compressed";
		}else  if(extension.equals("docx") || extension.equals("DOCX")){
			mime="application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		}else  if(extension.equals("xlsx") || extension.equals("XLSX") ){
			mime="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}else  if(extension.equals("pptx") || extension.equals("PPTX")  ){
			mime="application/vnd.openxmlformats-officedocument.presentationml.presentation";
		}
		else if(extension.equals("png") || extension.equals("PNG")){
			mime="image/png";
		}
		else if(extension.equals("bmp") || extension.equals("BMP") ){
			mime="image/bmp";

		}

		return mime;
	}

	public static String anioActual()
	{
		Calendar cal= Calendar.getInstance();
		int year= cal.get(Calendar.YEAR);
		return ""+year;
	}

	public static String lineOut() {
		int level = 3;
		StackTraceElement[] traces;
		traces = Thread.currentThread().getStackTrace();
		return (" at "  + traces[level] + " " );
	}




	public static  byte[]  generarBase64file(InputStream file ) throws IOException {

		return  Base64.getEncoder().encode(IOUtils.toByteArray(file));
	}

	private static String obtenerMesLetras(int mes) {	
		String desMes = "";
		switch (mes) {	
		case 1:
			desMes = "Enero";
			break;
		case 2:
			desMes = "Febrero";
			break; 
		case 3:
			desMes = "Marzo";
			break; 
		case 4:
			desMes = "Abril";
			break;
		case 5:
			desMes = "Mayo";
			break; 
		case 6:
			desMes = "Junio";
			break; 
		case 7:
			desMes = "Julio";
			break; 
		case 8:
			desMes = "Agosto";
			break; 
		case 9:
			desMes = "Septiembre";
			break; 
		case 10:
			desMes = "Octubre";
			break; 
		case 11:
			desMes = "Noviembre";
			break; 
		case 12:
			desMes = "Diciembre";
			break; 
		default:
			desMes = "";
			break;

		}
		return desMes;
	}
	public static MediaType getMediaTypeForExtension(String extension) {		
		try {
			MediaType mediaType = MediaType.parseMediaType(obtenerMimeType(extension));
			return mediaType;
		} catch (Exception e) {
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}
	
	public static String getFormatearFecha(Date fecha) {
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sm.format(fecha);
		return strDate;
	}


	public static String getFormatearMontos(BigDecimal monto) {


		return NumberFormat.getNumberInstance(Locale.US).format(monto);

	}

	public static String generarHashMD5(String password) throws NoSuchAlgorithmException
	{


		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public static String generarFechaConcatenada()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String fechaComoCadena = sdf.format(new Date());
		return fechaComoCadena;
	}

	public static String generarNumeroAleatorio()
	{
		Long numero = ThreadLocalRandom.current().nextLong(100000L, 10000000000L + 1);

		return numero.toString();
	}


	public static Date stringToDate(String fecha) 
	{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = new Date(sdf.parse(fecha).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static File getFile(String path) throws FileNotFoundException {
		File file = new File(path);
		if (!file.exists()){
			throw new FileNotFoundException("file with path: " + path + " was not found.");
		}
		return file;
	}

	public static void generarDocumento(byte[] archivoBytes, String path, String filename)
	{

		try {

			FileUtils.writeByteArrayToFile(new File(path+filename), archivoBytes);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	public static String obetenerPath(String nu_emi)

	{
		String filePath = new File("").getAbsolutePath()+File.separator; 
		File folder = new File(filePath+File.separator+nu_emi);
		if (!folder.exists()) {
			folder.mkdir();	
		}
		return filePath+nu_emi+File.separator;
	}	

	public static int obtenerAnioActual()
	{
		Calendar cal= Calendar.getInstance();
		int year= cal.get(Calendar.YEAR);
		return year;
	}
	
	
	public static String  toStr(Object valor) {
		if(valor==null){
			return "";
		}
		
		return valor.toString();
		
	}
	
	
}




