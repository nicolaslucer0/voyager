<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="index"  value="/" />
<c:url var="itemOrder"  value="/order" />
<c:url var="offer"  value="/order/" />
<c:url var="login"  value="/login" />
<c:url var="signup"  value="/signup" />
<c:url var="logo"  value="//img/logo.png"/> 


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="${index}"><img src="${logo}" class="logo" alt="Logo"></a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="${itemOrder}">Crear un pedido</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${offer}">Gana dinero con nosotros</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${login}">Iniciar Sesion</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${signup}">Registrarse</a>
      </li>
    </ul>
  </div>
</nav>
