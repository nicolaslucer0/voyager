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
		<div class="card search-box">
			<div id="search">
<%-- 			<form id="nameForm" action="<c:url value="/order/MLA/"></c:url>" method="GET"> --%>
				<h3>Crear un pedido:</h3>
				<p>Para crear un nuevo pedido, por favor, inserte el nombre del producto que est&aacute; buscando.</p>
	 			<div class="input-group mb-3">
				  <input type="text" class="form-control" id="itemName" placeholder="Nombre del producto...">
	  				<div class="input-group-append">
	    				<button id="findItems" class="btn btn-primary" type="button" 
	    				data-action="<c:url value="/order/MLA/"></c:url>" >Crear Item</button>
	  				</div>
				</div>
<!-- 			</form> -->
			</div>
		</div>
		<div id="search-result-container"></div>
		
	</div>
	<!-- Item selection card template -->
		<div id="search-result-template" class="card" style="display: none;">
			<input type="hidden" class="id">
  			<div class="card-body">
				<img class="card-img-top thumbnail">
				<p class="description"></p>
  			</div>
  			<div class="card-footer text-muted">
				<button type="button" class="btn btn-primary" onclick="createBasedOnThisElement()">Este es el que quiero</button>
			</div>
		</div>
</body>
</html>