<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/showDetail.js"/>"></script>

</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
 	<div class="container">
	<div class="d-flex align-content-around flex-wrap">
			<!-- CARDS -->
			<c:forEach var="offer" items="${myOffers}">
                <div class="card card-item d-flex align-items-stretch"> 
					<img class="card-img-top" alt="${offer.itemOrder.item.imagen}" src="${offer.itemOrder.item.imagen}">
					<div class="card-body">
						<h5 class="card-title">${itemOrder.item.nombre}</h5>
                        <p class="card-text">${itemOrder.item.descripcion}</p>
                        <p>Cant:<strong>${itemOrder.item.cantidad}</strong></p>
                        <p>Precio: u$s <strong>${itemOrder.item.precio}</strong></p>
						<p>Pais destino: <strong>${itemOrder.paisDestino}</strong></p>
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
	        <h5 class="modal-title" id="exampleModalLongTitle">Pagar pedido?</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      <p>Al presionar 'Pagar', ser&aacute; direccionado a la p&aacute;gina de MercadoPago</p>
	      </div>
	      <div class="modal-footer">
			<input id="cancelButton" type="button" 
                    class="btn btn-danger" 
                    value="Pagar" 
                    data-title="Pagos" 
                    data-message="Direccionando a MercadoPago." 
                    data-url=""/> 	        
          	<button type="button" class="btn btn-warn" data-dismiss="modal">Volver</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>

</html>