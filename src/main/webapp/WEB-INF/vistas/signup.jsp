<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/main.css" rel="stylesheet">
	</head>
	<body class="login">
		<jsp:include page='fragments/navbar.jsp'/>
	
		<div class = "container login-container">
			<div id="loginbox" class="login-modal mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-signup" method="POST" modelAttribute="user">
			    	<img src="<c:url value = "/img/logo.png"/>" class="form-logo form-signin-heading">
					<hr class="colorgraph"><br>
					<h4>Ingrese su email y contraseņa para continuar</h4>
					<br>
					<form:input path="name" id="name" type="text" class="form-control" placeholder="Nombre" />
					<br>
					<form:input path="lastName" id="lastName" type="text" class="form-control" placeholder="Apellido" />
					<br> 
					<form:input path="email" id="email" type="email" class="form-control" placeholder="email" />
					<br>
					<form:input path="password" type="password" id="password" class="form-control" placeholder="contraseņa"/>     		  
					<br>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>
				</form:form>

				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
