<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
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
                        <a class="nav-link" href="#">Gana dinero con nosotros</a>
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
	 * Contenido: Mensaje de error al querer grabar un pedido
	-->
	<div class="jumbotron" style="background-color: #eab7b7;">
	  <div class="container">
    		<h1>¡Ups!</h1>
		  <p>${ mensaje1 }</p>
		  <p><a class="btn btn-primary btn-lg" href="<c:url value="/" />" role="button">Volver</a></p>
  	  </div>	  
	</div>
	
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>