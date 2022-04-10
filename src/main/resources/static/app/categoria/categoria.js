


//TABLA DE LA ACTIVIDAD OPERATIVA
$(document).ready(function() {
	TablaCategoria();
} );


function  TablaCategoria(){
    $('#TablaCategoria').DataTable({

      "language": {
      "emptyTable":			"<i>No hay datos disponibles en la tabla.</i>",
      "info":		   		"Del _START_ al _END_ de _TOTAL_ ",
      "infoEmpty":			"Mostrando 0 registros de un total de 0.",
      "infoFiltered":			"(filtrados de un total de _MAX_ registros)",
      "infoPostFix":			"(actualizados)",
      "lengthMenu":			"Mostrar _MENU_ registros",
      "loadingRecords":		"Cargando...",
      "processing":			"Procesando...",
      "search":			"<span style='font-size:15px;'>Buscar:</span>",
      "searchPlaceholder":		"Dato para buscar",
      "zeroRecords":			"No se han encontrado coincidencias.",
      "paginate": {
        "first":			"Primera",
        "last":				"Última",
        "next":				"Siguiente",
        "previous":			"Anterior"
      },
      "aria": {
        "sortAscending":	"Ordenación ascendente",
        "sortDescending":	"Ordenación descendente"
      }
    },

    "lengthMenu":		[[3,5,7, 10, 20, 25, 50, -1], [3,5,7, 10, 20, 25, 50, "Todos"]],
    "iDisplayLength":	10,





    });
}




//FUNCION PARA GUARDAR LOS DATOS DE LA ACTIVIDAD OPERATIVA
function guardarDatosCategoria() {
  
  
    console.log("entro");
  
  var baseURL = $("meta[name='ctx']").attr("content");    

  
  //var url = baseURL + '/casoscon';
  var url = baseURL+'/categoria/guardar';

  var form = $('#frmUsuario')[0];

  var data = new FormData(form);
  

  var nuevo = $("#nombre_categoria").val();
  console.log(baseURL, "*********");

  
  $.ajax({
    type: "POST",
    enctype: 'multipart/form-data',
    url: url,
    data: data,
    processData: false, //prevent jQuery from automatically transforming the data into a query string
    contentType: false,
    cache: false,
    beforeSend : (request) => {
      
      
      //this.desbloquearPantalla();//desbloqueamos la pantalla  
    },
    success: (data) => {
      
      console.log("si11111");
      //this.desbloquearPantalla();//desbloqueamos la pantalla    
      
       if(data.status=='Done'){
       
         console.log("si///////////");
      //  $('#modalActividad').modal('hide');
      //  $('.modal-backdrop').remove();
      Swal.fire(
              'Datos guardados correctamente!',
              'Presione Ok!',
              'success'
            )
        //mensaje("success","Success",data.data); 
        //ENVIA A LA LISTA DE ACTIVIDADES
          viewCategoria();

        
    //ENVIA A LA LISTA DE ACTIVIDADES
        //modal-backdrop fade show
          
      }else{  
        //mensaje("warning","Advertencia", data.data);    
      
      }
        
    },
    error: (e) => { 
      //this.desbloquearPantalla();//desbloqueamos la pantalla  
      //mensaje("error","Error", 'Ocurrió un problema, vuelva a intentarlo y si el problema persiste contáctese con el Administrador.');    
            
    }
  }); 

  
}
             
//LISTA LAS CATEGORIAS DESPUES DE GUARDAR LOS DATOS


function viewCategoria(){
  console.log("si");
  var baseURL = $("meta[name='ctx']").attr("content");    
    
  
   var url = baseURL + '/categoria/listarCategoria'; 


	$("#fragDinamico").load(url)

 
}

function editarCategoria(id,idarchivo){

	console.log("editar entro-----");

	let  baseURL = $("meta[name='ctx']").attr("content");
	
	let url = baseURL + '/categoria/editar-categoria/'+id+'/'+idarchivo;
	console.log(url);
	$("#fragDinamico").load(url);


}

