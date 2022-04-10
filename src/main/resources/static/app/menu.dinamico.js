
//INICIALIZAR
var baseURL = $("meta[name='ctx']").attr("content");	

$(function() {

	$(document).ready( () => {
		
		inicializarMenuDinamico();	
		
	});

});

function inicializarMenuDinamico(){	
		
}

//Link del menu para trabajar con fragmentos

function viewListaUsuarios(){
	
	var baseURL = $("meta[name='ctx']").attr("content");		
		
	var url = baseURL + '/usuario/listar-usuarios';	

	$("#fragDinamico").load(url);	
}

// vista para las categorias
function viewListCategory(){

	console.log("entro categoria ok");

	var baseURL = $("meta[name='ctx']").attr("content");

	var url = baseURL+ '/categoria/listarCategoria';

	$("#fragDinamico").load(url)


}

function viewmap(){

	console.log("MAPA");
	
	var baseURL = $("meta[name='ctx']").attr("content");
	var url = baseURL+'/mapa/view';
	$("#fragDinamico").load(url);
	
}

function viewListaTipoUsuarios() {
	
	var baseURL = $("meta[name='ctx']").attr("content");	
	
	var url = baseURL + '/tipousuario/listar-tipo-usuarios';	
	
	$("#fragDinamico").load(url);	
	
}


$('#lkAdminProfesiones').on('click',function() {
	
	$.ajax({
	    type:"GET",
	    url: baseURL+"/profesiones/generarvistaprofesiones",
	    success: function (data) {
	    
	    	$("#fragDinamico").html(data);
	    },
	    error: function (request, error) {
	        console.log(request);
	        mensaje("error","Error","Ocurrío un error en la respuesta del servidor");
	       
	    }
	});
})


function cambioClaveUsuario(){
	
	var baseURL = $("meta[name='ctx']").attr("content");		
	
	var url = baseURL + '/cambioClave/cambio-clave';
	
	$("#fragDinamico").load(url);	
}



$('#lkAdminValores').on('click',function(){
	
	$.ajax({
	    type:"GET",
	    url: baseURL+"/listavalor/generarvistalistavalor",
	    success: function (data) {
	    
	    	$("#fragDinamico").html(data);
	    },
	    error: function (request, error) {
	        console.log(request);
	        mensaje("error","Error","Ocurrío un error en la respuesta del servidor");
	       
	    }
	});
})


		
	


