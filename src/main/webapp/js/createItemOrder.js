$(document).ready(function () {
	$("#regForm").stepWizard();
	$.getJSON("/voyager/JSON/countries.JSON", function(data){
		$("#paisDestino").select2({
			data: data
		});
	});
	
	
	$('#findItems').on('click', function() {
		if (!!$('#itemName').val()){
			var action = $("#findItems").data('action');
			action = action + $('#itemName').val();
			location.href=action
		} else {
			 $('#itemName').addClass('is-invalid');
		}
	})
	
		$('#itemName').on('keyup', function() {
			if ($('#itemName').val().length > 10){
				var name = $('#itemName').val();
				var url = $('#findItems').data('url');
				url = url + name + "&limit=5";
				$.get(url, function(data, status){
			        alert("Data: " + data.results + "\nStatus: " + status);
			        data = prepareData(data.results)
			        $.ajax({
			            type: 'get', 
			            'url': '/voyager/order',
			            data: data.results,
			            dataType: 'json',
			            success: function(response){ 
			            	debugger;
			            },
			            timeout: 10000,
			            error: function(xhr, status, err){ 
			            	debugger;
			            }
			        }); 
			    });
			}
		});
			
});

//TODO: VALIDAR PASOS DEL FORM
function validateFirstStep(){
	var error = 0;
	if (!$('#itemNombre').val()){
		$('#itemNombre').addClass('is-invalid');
		error++;
	} else {
		$('#itemNombre').removeClass('is-invalid');
		$('#itemNombre').addClass('is-valid');
	}
	
	if (!$('#itemUrl').val()){
		$('#itemUrl').addClass('is-invalid');
		error++;
	} else {
		$('#itemUrl').removeClass('is-invalid');
		$('#itemUrl').addClass('is-valid');
	}
	
	if (!$('#itemcantidad').val()){
		$('#itemcantidad').addClass('is-invalid');
		error++;
	} else {
		$('#itemcantidad').removeClass('is-invalid');
		$('#itemcantidad').addClass('is-valid');
	}
	
	if (!$('#itemPrecio').val()){
		$('#itemPrecio').addClass('is-invalid');
		error++;
	} else {
		$('#itemPrecio').removeClass('is-invalid');
		$('#itemPrecio').addClass('is-valid');
	}
	
	if (error > 0)
		return false;
}

//TODO: VALIDAR PASOS DEL FORM
function validateSecondStep(){
	alert();
}

function prepareData(data){
	debugger;
	if(!!data){
		data[0];
	}
}

