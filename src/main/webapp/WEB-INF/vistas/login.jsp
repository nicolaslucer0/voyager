<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page='fragments/imports.jsp' />
</head>
<body class="background">

	<jsp:include page='fragments/navbar.jsp' />
	<div class="flex-body">
		<div class="card card-width login-modal">
			<div class="card-body login-modal">
				<form:form action="login" method="POST"
					modelAttribute="user">
					<img src="<c:url value = "/img/logo.png"/>"
						class="form-logo form-signin-heading">
					<hr class="colorgraph">
					<br>
					<h4>Ingrese su email y contraseņa para continuar</h4>
					<br>

					<form:input path="email" id="email" type="email"
						class="form-control" placeholder="Email" />
					<br>
					<form:input path="password" type="password" id="password"
						class="form-control" placeholder="Contraseņa" />
					<br>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Login</button>
				</form:form>

				<c:if test="${not empty error}">
					<h4>
						<span>${error}</span>
					</h4>
					<br>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
