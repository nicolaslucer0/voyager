<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/validateRegister.js"/>"></script>
</head>
<body class="background">
	<jsp:include page='fragments/navbar.jsp' />
	<div class="flex-body">
		<div class="card signup-modal">
			<div class="card-body login-modal">
				<form:form id="regForm" action="signup" method="POST" modelAttribute="user">
					<img src="<c:url value = "/img/logo.png"/>"
						class="form-logo form-signin-heading">
					<hr class="colorgraph">
					<br>
					<h4>Ingrese sus datos para continuar</h4>
					<div class="form-group">
						<form:input path="name" id="name" type="text" class="form-control"
							placeholder="Nombre" />
					</div>
					<div class="form-group">
						<form:input path="lastName" id="lastName" type="text"
							class="form-control" placeholder="Apellido" />
					</div>
					<div class="form-group">
						<form:input path="email" id="email" type="email"
							class="form-control" placeholder="E-mail" />
					</div>
					<div class="form-group">
						<form:input path="password" type="password" id="password"
							class="form-control" placeholder="Contraseña" />
					</div>
					<div class="form-group">
						<input type="button" class="btn btn-lg btn-primary btn-block" onclick="validateForm('R')" value="Registrarse" />
					</div>
				</form:form>
				<span id="errorForm" data-error="${error}"></span>
				
			</div>
		</div>
	</div>
</body>
</html>
