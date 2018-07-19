$(document).ready(function() {
	$('#exampleModalCenter').on('show.bs.modal', function(event) {
		var data = { 'orderId': $(event.relatedTarget).data('id') };
		
		$('#btnMercadoPago').prop('disabled', true);
		$('#btnMercadoPago').addClass('disabled');
		
		$.ajax({
			type : "get",
			data : data,
			url : "getMPLink",
			success : function(urlMP) {
				$('#btnMercadoPago').data('MP-url', urlMP);
				$('#btnMercadoPago').prop('disabled', false);
				$('#btnMercadoPago').removeClass('disabled');
			}
		});
		
	});
	
	$('#btnMercadoPago').on('click', function(){
		location.href = $(this).data('MP-url');
	});
	
});