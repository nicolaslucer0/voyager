<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:url var="post_url" value="/order" />
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
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div wizard>
	<form:form id="regForm" action="${post_url}" method="POST" modelAttribute="itemOrder">
	<div class="row">
			<h1>Nueva orden de producto:</h1>
			<div wizard-step canexit="validateFirstStep">
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

			<div wizard-step canexit="validateSecondStep">
				<h4>Descripci&oacute;n</h4>
				<form:label path="item.descripcion" for="itemDescripcion">Danos un descripción del producto que estas buscando.</form:label>
				<form:textarea path="item.descripcion" class="form-control" id="itemDescripcion" placeholder="Descripción del producto" />
				<form:label path="item.imagen" for="itemImage">Ingresa el URL de una imagen para mostrar.</form:label>
				<form:textarea path="item.imagen" class="form-control" id="itemImage" placeholder="URL de imagen" />
			</div>
	</div>
	<div class="row">
		<div class="col-md-12 text-right">
			<div class="form-group">
				<button wizard-previous type="button" class="btn">Anterior</button>
				<button wizard-next type="button" class="btn">Siguiente</button>
				<button wizard-last class="btn btn-primary" id="startAssignationBtn">Crear item</button>
			</div>
		</div>
	</div>
	</form:form>
</div>
	</div>
	</div>
</body>
</html>