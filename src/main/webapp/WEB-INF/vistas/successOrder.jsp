<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page='fragments/imports.jsp' />
</head>
<body>
<jsp:include page='fragments/navbar.jsp' />

	<div class="jumbotron" style="background-color: #bde9ab;">
	  <div class="container">
    		<h1>¡Exito!</h1>
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