$(document).ready(function() {

	var currentTab = 0; // Current tab is set to be the first tab (0)
	showTab(currentTab); // Display the current tab

	// BOTON SIGUIENTE
	$("#nextBtn").on("click", function (){
		
		var x = $(".tab");
		x[currentTab].style.display = "none";
		currentTab = currentTab + 1;
		if (currentTab >= x.length) {
			// ...the form gets submitted:
			document.getElementById("regForm").submit();
			return false;
		}
		x[currentTab].style.display = "block";
		showTab(currentTab);
	});
	
	// BOTON ANTERIOR
	$("#prevBtn").on("click", function (){
		var x = $(".tab");
		x[currentTab].style.display = "none";
		currentTab = currentTab - 1;
		if (currentTab >= x.length) {
			// ...the form gets submitted:
			document.getElementById("regForm").submit();
			return false;
		}
		x[currentTab].style.display = "block";
		showTab(currentTab);
	});
});

function showTab(n) {
	// CREA ARRAY DE TABS Y CAMBIA
	var x = $(".tab");
	  x[n].style.display = "block";
	if (n == 0) {
		document.getElementById("prevBtn").style.display = "none";
	} else {
		document.getElementById("prevBtn").style.display = "inline";
	}
	if (n == (x.length - 1)) {
		document.getElementById("nextBtn").innerHTML = "Crear Item";
	} else {
		document.getElementById("nextBtn").innerHTML = "Next";
	}
	fixStepIndicator(n)
}

function fixStepIndicator(n) {
	// This function removes the "active" class of all steps...
	var i, x = document.getElementsByClassName("step");
	for (i = 0; i < x.length; i++) {
		x[i].className = x[i].className.replace(" active", "");
	}
	// ... and adds the "active" class to the current step:
	x[n].className += " active";
}