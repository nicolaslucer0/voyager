$(document).ready(function () {
	if (!!$('#errorForm').data('error'))
		showToast('Error',$('#errorForm').data('error'),'danger');

});

function validateForm(type){
	var err = 0;
	if (!$('#email').val()){
		err++; 
		$('#email').addClass('is-invalid');
	} else {
		$('#email').removeClass('is-invalid');
		$('#email').addClass('is-valid');
	}
	if (!$('#password').val()){
		err++; 
		$('#password').addClass('is-invalid');
	} else {
		$('#password').removeClass('is-invalid');
		$('#password').addClass('is-valid');
	}
	
	if (type == 'R'){
		if (!$('#name').val()){
			$('#name').addClass('is-invalid');
			err++; 
		} else {
			$('#name').removeClass('is-invalid');
			$('#name').addClass('is-valid');
		}
		if (!$('#lastName').val()){
			$('#lastName').addClass('is-invalid');
			err++; 
		} else {
			$('#lastName').removeClass('is-invalid');
			$('#lastName').addClass('is-valid');
		}
	}
	
	if (err == 0){
			showToast('Registro','Estableciendo conexion','success');
			
		setTimeout(function() {
			$("#regForm").submit();
		}, 1000);
	} else {
		showToast('Error','Por favor, complete los campos para continuar','danger');
	}
	
}