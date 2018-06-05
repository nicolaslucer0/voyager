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
		<div class = "container login-container">
			<div id="loginbox" class="login-modal mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-login" method="POST" modelAttribute="user">
			    	<img src="<c:url value = "/img/logo.png"/>" class="form-logo form-signin-heading">
					<hr class="colorgraph"><br>
					<h4>Ingrese su email y contraseña para continuar</h4>
					<br>
					
					<form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
					<br>
					<form:input path="password" type="password" id="password" class="form-control" placeholder="Contraseña"/>     		  
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
