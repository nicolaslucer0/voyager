$(document).ready(function() {
	$('#exampleModalCenter').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var url = button.data('url');

		var data = { 'orderId': button.data('id') };
		
		$('#btnMercadoPago').prop('disabled', true);
		$('#btnMercadoPago').addClass('disabled');
		
		$.ajax({
			type : "get",
			data : data,
			url : "getMPLink",
			success : function(urlMP) {
				$('#btnMercadoPago').attr('href', urlMP);
				$('#btnMercadoPago').prop('disabled', false);
				$('#btnMercadoPago').removeClass('disabled');
			}
		});
	})
});
