$(document).ready(function () {
	$('#exampleModalCenter').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var id = button.data('id') // Extract info from data-* attributes
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.btn-primary').attr("href", "/voyager/offer/order/"+id);
//		  modal.find('.btn btn-primary')[href='http://www.google.com/'];
//		  modal.find('.modal-body input').val(recipient)
		})
});
