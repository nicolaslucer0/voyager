<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="post_url" value="/order" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	<div class="container">
		<div class="card">
			<div id="" class="card-body">
				<h1>Cuéntanos sobre tu artículo</h1>
				<p class="lead">Si tu producto esta disponible en alguna web,
					pegá el link de compra debajo</p>
				<form:form action="${post_url}" method="POST" modelAttribute="itemOrder">
					<div class="row">
						<div class="col col-md-8">
							<div class="form-group">
								<form:label path="item.url" for="itemUrl">Ingresa la URL del producto que estas buscando.</form:label>
								<form:input path="item.url" type="text" class="form-control"
									id="itemUrl" placeholder="URL del producto" />
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col col-md-8">
							<div class="form-group">
								<form:label path="item.nombre" for="itemNombre">Nombre del producto.</form:label>
								<form:input path="item.nombre" type="text" class="form-control"
									id="itemNombre" placeholder="Nombre del producto" />
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col col-md-4 ">
							<div class="form-group">
								<form:label path="item.cantidad" for="itemUrl">Ingresa la cantidad que buscas.</form:label>
								<form:input path="item.cantidad" type="number"
									class="form-control" id="itemcantidad" placeholder="Cantidad 1" />
							</div>
						</div>
						<div class="col col-md-4">
							<div class="form-group">
								<form:label path="item.precio" for="itemPrecio">Precio del producto en USD.</form:label>
								<form:input path="item.precio" type="number"
									class="form-control" id="itemPrecio"
									placeholder="Maximo u$d 1000" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-8 ">
							<div class="form-group">
								<form:label path="description" for="itemDescripcion">Danos un descripción del producto que estas buscando.</form:label>
								<form:textarea path="description" class="form-control"
									id="itemDescripcion" placeholder="Descripción del producto" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-8 ">
							<div class="form-group">
								<form:label path="item.imagen" for="itemImage">Ingresa el URL de una imagen para mostrar.</form:label>
								<form:textarea path="item.imagen" class="form-control"
									id="itemImage" placeholder="URL de imagen" />
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Crear pedido</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>