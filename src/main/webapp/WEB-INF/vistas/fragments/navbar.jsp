<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="index"  value="/" />
<c:url var="itemOrder"  value="/order" />
<c:url var="offer"  value="/" />
<c:url var="login"  value="/login" />
<c:url var="signup"  value="/signup" />
<header>
	<div class="container-fluid">
		<div class="row navbar"> 
			<div class="col-sm-12 col-md-3">
				<a href="${index}"><img src="./img/logo.png" class="logo" alt="Logo"></a>
			</div>
			<div class="col-sm-12 col-md-9">
				<div class="col col-sm-12 col-md-3 nav-item">
					<a class="nav-link" href="${itemOrder}">Crear un pedido</a>
				</div>
				<div class="col-sm-12 col-md-3 nav-item">
					<a class="nav-link" href="${offer}">Gana dinero con nosotros</a>
				</div>
				<div class="col-sm-12 col-md-3 nav-item">
					<a class="nav-link" href="${login}">Iniciar sesion</a>
				</div>
				<div class="col-sm-12 col-md-3 nav-item">
					<a class="nav-link" href="${signup}">Registrarse</a>
				</div>
			</div>
		</div>
	</div>
</header>