<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<jsp:include page='fragments/imports.jsp' />
</head>
<body style="text-align:center;">
<jsp:include page='fragments/navbar.jsp' />
	<div class="container">
		<h1>Proceso finalizado con &eacute;xito.</h1>
		<a class="btn btn-primary">Volver al inicio</a>
		<a class="btn btn-primary">Hacer un pedido</a>
		<a class="btn btn-primary">Ofertar sobre pedidos</a>
	</div>
</body>
</html>