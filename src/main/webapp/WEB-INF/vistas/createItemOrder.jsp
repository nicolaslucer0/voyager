<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cree su pedido</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/main.css" rel="stylesheet">
</head>
<body>
	<header>
        <div class="container-fluid">
            <div class="row navbar">
                <div class="col-sm-12 col-md-3">
                <a href="<c:url value = "/"/>"><img src="./img/logo.png" class="logo" alt="Logo"></a>
                </div>
                <div class="col-sm-12 col-md-9">
                    <div class="col col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value = "/order"/>">Crear un pedido</a>
                    </div>
                    <div class="col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value="/order/all" />">Gana dinero con nosotros</a>
                    </div>
                    <div class="col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value = "/login"/>" >Iniciar sesion</a>
                    </div>
                    <div class="col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value = "/signup"/>">Registrarse</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <!-- 
    * Contenido: Formulario para que el comprador genere un pedido
	* @return ItemOrder: Envia los datos al action order por POST, función saveItemOrders.
    -->
    <div class="container">    	
    	
   		<h1>Cuéntanos sobre tu artículo</h1>
    	<p class="lead">
		 Si tu producto esta disponible en alguna web, pegá el link de compra debajo
		</p>
    	<c:url var="post_url"  value="/order" />
    	<form:form action="${post_url}" method="POST" modelAttribute="itemOrder">
			<div class="row">
				<div class="col col-md-8">
			      <div class="form-group">
				    <form:label path="item.url" for="itemUrl">Ingresa la URL del producto que estas buscando.</form:label>
				    <form:input path="item.url" type="text" class="form-control" id="itemUrl" placeholder="URL del producto"/>
				  </div>
				</div>
				
			</div>
			<div class="row">
				<div class="col col-md-8">
			      <div class="form-group">
				    <form:label path="item.nombre" for="itemNombre">Nombre del producto.</form:label>
				    <form:input path="item.nombre" type="text" class="form-control" id="itemNombre" placeholder="Nombre del producto"/>
				  </div>
				</div>
				
			</div>
			<div class="row">
				<div class="col col-md-4 ">
			      <div class="form-group">
				    <form:label path="item.cantidad" for="itemUrl">Ingresa la cantidad que buscas.</form:label>
				    <form:input path="item.cantidad" type="text" class="form-control" id="itemcantidad" placeholder="Cantidad 1"/>
				  </div>
				</div>
				<div class="col col-md-4">
			      <div class="form-group">
				    <form:label path="item.precio" for="itemPrecio">Precio del producto en USD.</form:label>
				    <form:input path="item.precio" type="text" class="form-control" id="itemPrecio" placeholder="Maximo u$d 1000"/>
				  </div>
				</div>
			</div>
			<div class="row">
				<div class="col col-md-8 ">
			      <div class="form-group">
				    <form:label path="description" for="itemDescripcion">Danos un descripción del producto que estas buscando.</form:label>
				    <form:textarea path="description" class="form-control" id="itemDescripcion" placeholder="Descripción del producto"/>
				  </div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Crear pedido</button>
		</form:form>
    </div>


		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>