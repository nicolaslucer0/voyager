$(document).ready(function () {
    url = $("#ejemploAjax").data("url");
	
	$('#ejemploAjax').on('click', function(){
		url = $(this).data("url");
		
		$.get(url, function(data, status){
			$.each(data.results, function(index, step){
				$('#ejemploAjax').select2({
					results: step.title
				})
				console.dir(step.id + step.title);
			});
	    });
	})
});
