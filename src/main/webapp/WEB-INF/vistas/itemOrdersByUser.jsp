<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/showConfirm.js"/>"></script>
</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	<c:set var="imagen" value=""></c:set>
	<c:if test="${mensajeError != ' '}">
		${mensajeError}
  	</c:if>

	<div class="container">
		<div class="row">
			<!-- CARDS -->
			<c:forEach var="order" items="${itemOrders}">
				<div class="card card-offer" style="width: 21rem;">
					<img src="${order.item.imagen}" class="card-img-top" alt="${order.item.nombre}"  data-src="">
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
							<a href="<c:url value="/itemOrder/${order.id}"/>" class="btn btn-default" role="button">Detalle</a>
						</p> 
					</div>
				</div>
			</c:forEach>
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
	</div>
</body>

</html>