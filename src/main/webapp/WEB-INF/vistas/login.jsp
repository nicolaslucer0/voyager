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
		<div class="card card-width login-modal">
			<div class="card-body login-modal">
				<form:form id="regForm" action="login" method="POST" modelAttribute="user">
					<img src="<c:url value = "/img/logo.png"/>"
						class="form-logo form-signin-heading">
					<hr class="colorgraph">
					<br>
					<h4>Ingrese su email y contrase�a para continuar</h4>
					<br>

					<form:input path="email" id="email" type="email"
						class="form-control" placeholder="Email" />
					<br>
					<form:input path="password" type="password" id="password"
						class="form-control" placeholder="Contrase�a" />
					<br>
					<input type="button" class="btn btn-lg btn-primary btn-block" onclick="validateForm('L')" value="Iniciar sesion" />
				</form:form>

				<span id="errorForm" data-error="${error}"></span>
			</div>
		</div>
	</div>
</body>
</html>
