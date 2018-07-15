<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/createItemOrder.js"/>"></script>
<script type="text/javascript" src="<c:url value="//js/wizard/step-wizard.js"/>"></script>
</head>

<!-- ################################################################### -->
<!-- ################## CREAR PEDIDO INPUT INICIAL ##################### -->
<!-- ################################################################### -->

<body>
	<jsp:include page='fragments/navbar.jsp' />

	<div class="d-flex p-2 main-content centered">
		<div class="card" style="justify-content: center; height: auto; width: 70%; padding: 2em;">
			<div id="search">
<%-- 			<form id="nameForm" action="<c:url value="/order/MLA/"></c:url>" method="GET"> --%>
				<h3>Crear un pedido:</h3>
				<p>Para crear un nuevo pedido, por favor, inserte el nombre del producto que está buscando.</p>
	 			<div class="input-group mb-3">
				  <input type="text" class="form-control" id="itemName" placeholder="Nombre del producto...">
	  				<div class="input-group-append">
	    				<button id="findItems" class="btn btn-primary" type="button" 
	    				data-action="<c:url value="/order/MLA/"></c:url>"  
	    				data-search="<c:url value="/order/MLA/search"></c:url>" 
	    				data-url="https://api.mercadolibre.com/sites/MLU/search?q=" >Crear Item</button>
	  				</div>
				</div>
<!-- 			</form> -->
			</div>
	</div>
	</div>
</body>
</html>