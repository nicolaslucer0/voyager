<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/showConfirm.js"/>"></script>
</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	
	<c:if test="${itemOrders eq null}">
		<div class='alert alert-danger centered' style="text-align: center; width: 80%; margin:20% auto 0 auto;" role='alert'>No hay solicitudes de compradores de momento, vuelva mas tarde.</div>
  	</c:if>
 	<div class="container">
	<div class="d-flex align-content-around flex-wrap">
			<!-- CARDS -->
			<c:forEach var="order" items="${itemOrders}">
				<div class="card card-item d-flex align-items-stretch">
					<img class="card-img-top" alt="${order.item.nombre}" src="${order.item.imagen}">
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${order.item.nombre}" />
						</h5>
						<p class="card-text">
							<c:out value="${order.item.descripcion}" />
						</p>
						<p class="text-left">
							Cant: <strong><c:out value="${order.item.cantidad}" /></strong>
							Precio: u$s <strong><c:out value="${order.item.precio}" /></strong>
						</p>
						<p>
						<button type="button" data-url="<c:url value="/offer/order/${order.id}"/>" data-id="${order.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Ofertar</button>
							<a href="<c:url value="/itemOrder/${order.id}"/>" class="btn btn-default" role="button">Detalle</a>
						</p> 
					</div>
				</div>
			</c:forEach>
	 	</div>
	</div>
		<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Confirmar oferta?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <p>Al aceptar, se generar&aacute; una nueva oferta sobre el pedido solicitado.</p>
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-primary" href="">Ofertar</a>
        <button type="button" class="btn btn-warn" data-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>
</body>

</html>