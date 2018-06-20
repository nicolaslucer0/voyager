<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="post_url" value="/order" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/form.js"/>"></script>
</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	<div class="flex-body">
	<form:form id="regForm" action="${post_url}" method="POST" modelAttribute="itemOrder">
	<h1>Nueva orden de producto:</h1> 
	
	<!-- One "tab" for each step in the form: -->
	<div class="tab">
		<h4>Informaci&oacute;n b&aacute;sica</h4> 
		<div class="row">
			<div class="col-md-12">
				<form:label path="item.nombre" for="itemNombre">Nombre del producto.</form:label>
				<form:input path="item.nombre" type="text" class="form-control" id="itemNombre" placeholder="Nombre del producto" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form:label path="item.url" for="itemUrl">Ingresa la URL del producto que estas buscando.</form:label>
				<form:input path="item.url" type="text" class="form-control" id="itemUrl" placeholder="URL del producto" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<form:label path="item.cantidad" for="itemUrl">Ingresa la cantidad que buscas.</form:label>
				<form:input path="item.cantidad" type="number" class="form-control" id="itemcantidad" placeholder="Cantidad 1" />
			</div>
			<div class="col-md-6">
				<form:label path="item.precio" for="itemPrecio">Precio del producto en USD.</form:label>
				<form:input path="item.precio" type="number" class="form-control" id="itemPrecio" placeholder="Maximo u$d 1000" />
			</div>
		</div>
	</div>
	
	<div class="tab">
		<h4>Descripci&oacute;n </h4> 
		<form:label path="description" for="itemDescripcion">Danos un descripción del producto que estas buscando.</form:label>
		<form:textarea path="description" class="form-control" id="itemDescripcion" placeholder="Descripción del producto" />
		<form:label path="item.imagen" for="itemImage">Ingresa el URL de una imagen para mostrar.</form:label>
		<form:textarea path="item.imagen" class="form-control" id="itemImage" placeholder="URL de imagen" />
	</div>
	<div style="overflow:auto; margin-top:1em;">
	  <div style="float:right;">
	    <button class="btn " type="button" id="prevBtn">Anterior</button>
	    <button class="btn btn-primary" type="button" id="nextBtn">Siguiente</button>  
	  </div>
	</div>
	<div style="text-align:center;margin-top:40px;">
	  <span class="step"></span>
	  <span class="step"></span>
	  <span class="step"></span>
	  <span class="step"></span>
	</div>
	</form:form>
	</div>
</body>
</html>