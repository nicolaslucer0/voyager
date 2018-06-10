<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/main.css" rel="stylesheet">
	</head>
	<body class="background">
		<jsp:include page='fragments/navbar.jsp'/>
		<div class="flex-body">
		<div class="card card-width">
		<div class="card-body login-modal">
				<form:form action="validar-signup" method="POST" modelAttribute="user">
			    	<img src="<c:url value = "/img/logo.png"/>" class="form-logo form-signin-heading">
					<hr class="colorgraph"><br>
					<h4>Ingrese su email y contraseña para continuar</h4>
					<br>
					<form:input path="name" id="name" type="text" class="form-control" placeholder="Nombre" />
					<br>
					<form:input path="lastName" id="lastName" type="text" class="form-control" placeholder="Apellido" />
					<br> 
					<form:input path="email" id="email" type="email" class="form-control" placeholder="email" />
					<br>
					<form:input path="password" type="password" id="password" class="form-control" placeholder="contraseña"/>     		  
					<br>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Login</button>
				</form:form>

				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		</div>
	</body>
</html>
