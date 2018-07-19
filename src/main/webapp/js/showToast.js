function showToast(title, message, type, timeout){
	$.toaster({
			title : title != null ? title : 'Default title', 
			message : message != null ? '<br>' + message : 'Default message', 
			priority : type != null ? type : 'success', 
			settings: {
				timeout: timeout != null ? timeout : 1000
			}
	});	
}