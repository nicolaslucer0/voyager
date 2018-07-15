$(document).ready(function () {
	$("#regForm").stepWizard();
	
	$('#findItems').on('click', function() {
		var _this = $(this);
		name = $('#itemName').val();
		var url = _this.data('url') + name; 
		if (!!name){
			var action = $("#nameForm").attr('action');
			action = action + name;
			$("#nameForm").attr('action', action);
			$("#nameForm").submit();
		} else {
			 $('#itemName').addClass('has-danger');
		}
	})
	
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