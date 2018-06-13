<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	<c:if test="${mensajeError != ' '}">
		<%-- 		<div class="alert alert-danger" role="alert">${mensajeError}</div> --%>
		${mensajeError}
  	</c:if>

	<div class="container">
		<div class="row">
			<!-- CARDS -->
			<c:forEach var="order" items="${itemOrders}">
				<div class="card card-offer" style="width: 21rem;">
					<img class="card-img-top" alt="${order.item.nombre}"
						src="${order.item.imagen}"
						data-src="">
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${order.item.nombre}" />
						</h5>
						<p class="card-text">
							<c:out value="${order.description}" />
						</p>
						<p class="text-left">
							Cant: <strong><c:out value="${order.item.cantidad}" /></strong>
							Precio: u$s <strong><c:out value="${order.item.precio}" /></strong>
						</p>
						<p>
							<a href="<c:url value="/offer/order/${order.id}"/>"
								class="btn btn-primary" role="button" style="width: 40%;">Ofertar</a>
							<a href="<c:url value="/itemOrder/${order.id}"/>"
								class="btn btn-default" role="button">Detalle</a>
						</p> 
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>