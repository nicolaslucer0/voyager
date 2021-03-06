$(document).ready(function () {
	$("#regForm").stepWizard();
	
	if (!!$('#itemNombre').val())
		showToast('Excelente', 'Ahora complete los datos restantes', 'success', 1000);

	
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
		var productName = $('#itemName').val();
		if (productName.length > 4){

			mercadoLibreService
				.findProductsByName(productName, 5)
				.done(response => {
					if(response.results) {
						var itemCards = response.results.map(itemToItemCard);
						$("#search-result-container").html(itemCards);
					} else
						$("#search-result-container").html(`No se encontraron productos similares a <b>${productName}</b>`);
				})
				.fail(err => {
					$("#search-result-container").html(`Ocurri\u00F3 un error al realizar la b\u00FAsqueda. Por favor, intente nuevamente.`);
				});
		}
	});
			
});

/**
 * Convierte un item de MercadoLibre en un div renderizable con un preview del
 * mismo.
 * 
 * @param {*}
 *            item
 */
function itemToItemCard(item) {
	var template = $("#search-result-template").clone();
	template.find(".title").text(item.title);
	template.find(".thumbnail").attr("src", item.thumbnail);
	template.find(".id").val(item.id);
	template.find(".id").data("id",item.id);
	template.find(".id").attr("data-id", item.id);
	template.show();
	return template;
}

function createBasedOnThisElement(){
	var template = $("#search-result-template").clone();
	var url = "/voyager/order/MLA/search/";
	var id = template.find(".id").data("id");
	url = url + id;
	location.href= url;

}

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
	
	if (error > 0){
		showToast('Error', 'Hay errores en los datos.', 'danger', 1000);
		return false;
	}
}

// TODO: VALIDAR PASOS DEL FORM
function validateSecondStep(){
	var error = 0;
	if (!$('#itemDescripcion').val()){
		$('#itemDescripcion').addClass('is-invalid');
		error++;
	} else {
		$('#itemDescripcion').removeClass('is-invalid');
		$('#itemDescripcion').addClass('is-valid');
	}
	
	if (!$('#itemImage').val()){
		$('#itemImage').addClass('is-invalid');
		error++;
	} else {
		$('#itemImage').removeClass('is-invalid');
		$('#itemImage').addClass('is-valid');
	}
	
	if (error > 0 ){
		showToast('Error', 'Hay errores en los datos.', 'danger', 1000);
		return false;
	}
	else {
		showToast('Pedido exitoso', 'Pedido creado con exito', 'success', 1000);
		setTimeout(function() {
			$("#regForm").submit();
		}, 1000);
	}
		
		
	}

