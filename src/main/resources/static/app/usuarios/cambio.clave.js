
$(function() {

	$(document).ready( () => {

		inicializarCambioClave();	

	});

});

function inicializarCambioClave(){	

	$('[data-toggle="tooltip"]').tooltip();

	//GUARDAR DATOS DEL FORMULARIO

	$("#btnGuardarCambioClave").click( (event) => {

		event.preventDefault();

		this.guardarDatosCambioClave();

	});	

}

function validarFormulario(){		

	if ($("#password").val() == null || $("#password").val() == ''){		
		mensaje("warning","Advertencia","Por favor ingrese su nuevo password");	
		$('#password').focus();
		return false;			
	}
	
	return true;

}


function guardarDatosCambioClave() {

	if (validarFormulario()) {	

		var baseURL = $("meta[name='ctx']").attr("content");		

		var url = baseURL + '/cambioClave/guardarCambioClave';

		var form = $('#frmCambioClave')[0];

		var data = new FormData(form);

		$.ajax({	
			type: "POST",			
			url: url,
			data: data,
			processData: false, //prevent jQuery from automatically transforming the data into a query string
			contentType: false,
			cache: false,
			beforeSend : (request) => {
				this.desbloquearPantalla();//desbloqueamos la pantalla	
			},
			success: (data) => {

				this.desbloquearPantalla();//desbloqueamos la pantalla		

				if(data.status=='Done'){
					mensaje("success","Success",data.data);						
				}else{	
					mensaje("warning","Advertencia", data.data);						
				}						
			},
			error: (e) => {		
				this.desbloquearPantalla();//desbloqueamos la pantalla		
				mensaje("error","Error", 'Ocurrió un problema, vuelva a intentarlo y si el problema persiste contáctese con el Administrador.');				
			}
		});		
	}
}






