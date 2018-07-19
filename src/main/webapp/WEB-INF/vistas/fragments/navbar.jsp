<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="index"  value="/" />
<c:url var="itemOrder"  value="/order/new" />
<c:url var="offer"  value="/order/" />
<c:url var="login"  value="/login" />
<c:url var="signup"  value="/signup" />
<c:url var="logout"  value="/logout" />
<c:url var="myItemOrders"  value="/order/myOrders" />
<c:url var="myOffers"  value="/offer/myOffers" />
<c:url var="myOrders"  value="/order/all"/>
<c:url var="myOfferedItemOrders"  value="/order/myOrders/offered" />
<c:url var="myOrdersAccepted"  value="/order/myOrders/offered" />
<c:url var="myOrdersTravelled"  value="/order/myOrders/offered" />

<c:url var="logo"  value="//img/logo.png"/> 


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav1" aria-controls="nav1" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="${index}"><img src="${logo}" class="logo" alt="Logo"></a>

  <div class="collapse navbar-collapse" id="nav1">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="${itemOrder}">Crear un pedido</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${offer}">Gana dinero con nosotros</a>
      </li>
      <c:if test="${userSession.id == null }">
	      <li class="nav-item">
	        <a class="nav-link" href="${login}">Iniciar Sesion</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${signup}">Registrarse</a>
	      </li>
      </c:if>
      
	<c:if test="${userSession.id != null }">
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       	Pedidos y pagos
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${myItemOrders}">Mis nuevos pedidos</a>
        <a class="dropdown-item" href="${myOfferedItemOrders}">Ofertas sobre mis pedidos</a>
        <a class="dropdown-item" href="${myOrdersAccepted}">Pendientes de pago</a>
        <a class="dropdown-item" href="${myOrdersTravelled}">Pedidos en viaje</a>
        <a class="dropdown-item" href="${myOrders}">Todos mis pedidos</a>
       </div>
    </li>
    
    <li class="nav-item dropdown">
      	<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			Ofertas y viajes
    	</a>
      	<div class="dropdown-menu">
			<a class="dropdown-item" href="${myOffers}">Ofertas que he creado</a>
 		</div>	
	</li>

    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        ${userSession.name}
      </a>
      <div class="dropdown-menu">
		<a class="dropdown-item" href="${logout}">Cerrar sesion</a></div>
    </li>
    
	</c:if>
    </ul>
  </div>
</nav>
