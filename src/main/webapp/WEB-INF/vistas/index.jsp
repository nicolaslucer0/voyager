<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="itemOrder"  value="/order/new" />
<c:url var="offer"  value="/order/" />

<!DOCTYPE html>
<html>
	<head>
	 	<jsp:include page='fragments/imports.jsp'/>
	</head>
	<body class="background">
	<jsp:include page='fragments/navbar.jsp'/>
	
	<div class="flex-body">
		<div class="row main-text">
			<div class="col-md-12">
				<h1 style="color:white">Voyager.</h1>
			</div>
			<div class="col-md-12">
				<h2 style="color:white">Compras alrededor del mundo.</h2>
			</div>
			
			<div class="col-md-12">
				<a class="btn btn-primary" href="${itemOrder}">Hacer un pedido</a>
				<a class="btn btn-info" href="${offer}">Ofertar sobre pedidos</a>
				
			</div>
		</div> 
	</div>
	</body>
</html>
