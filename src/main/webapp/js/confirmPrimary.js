$(document).ready(function () {
	$('#exampleModalCenter').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var url = button.data('url');
		  if (!!$('#selectEstado')){
				$('#selectEstado').select2();
			}
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.btn-primary').data("url",url);
		  modal.find('.btn-primary').attr("url",url);
	});	
		
	$('#confirmButton').on('click', function(){
		
		var url = $(this).data('url');
		$(this).prop('disabled', true);
		var message = $(this).data('message');
		var title = $(this).data('title');
		$(this).unbind();
		showToast(title, message, 'success', 500);
		setTimeout(function() {
			location.href = url;
		}, 500);
	});
	
	$('#cambiarEstado').on('click', function(){
		debugger;
		var url = $(this).data('url');
		var url = url + $('#selectEstado').select2().val();
		$(this).prop('disabled', true);
		var message = $(this).data('message');
		var title = $(this).data('title');
		$(this).unbind();
		showToast(title, message, 'success', 500);
		setTimeout(function() {
			location.href = url;
		}, 500);
	});

});
