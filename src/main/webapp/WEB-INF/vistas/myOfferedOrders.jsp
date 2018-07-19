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
		<div class='alert alert-danger' role='alert'>Nadie ha realizado pedidos por ahora.</div>
  	</c:if>
 	<div class="container">
	<div class="d-flex align-content-around flex-wrap">
			<!-- CARDS -->
			<c:forEach var="offer" items="${itemOrders}">
                <div class="card card-item d-flex align-items-stretch"> 
					<img class="card-img-top" alt="${offer.itemOrder.item.nombre}" src="${offer.itemOrder.item.imagen}">
						<div class="card-body">
						<h5 class="card-title">${offer.itemOrder.item.nombre}</h5>
                        <p class="card-text">${offer.itemOrder.item.descripcion}</p>
                        <p>Cant:<strong>${offer.itemOrder.item.cantidad}</strong></p>
                        <p>Precio: u$s <strong>${offer.itemOrder.item.precio}</strong></p>
						<p>Pais destino: <strong>${offer.itemOrder.paisDestino}</strong></p>
					</div>
                    <div class="modal-footer">
						<button type="button" data-url="<c:url value="/offer/${offer.id}/order/accept/${offer.itemOrder.id}"/>" data-id="${offer.itemOrder.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Aceptar Oferta</button>
                        <a data-toggle="modal" data-target="#detailModal${order.id}" class="btn btn-default detail" role="button">Detalle</a>
					</div>
				</div>
				
				 <!--  ###################### MODAL  #####################-->
                <div class="modal fade detail" id="detailModal${order.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="modal${ order.id}">Detalles</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">
                                    <img class="card-img-top" alt="${offer.itemOrder.item.nombre}" src="${offer.itemOrder.item.imagen}">
                                    <div class="card-body">
										<h5 class="card-title">${offer.itemOrder.item.nombre}</h5>
                                        <p class="card-text">${offer.itemOrder.item.descripcion}</p>
                            			<p>Cant:<strong>${offer.itemOrder.item.cantidad}</strong></p>
                            			<p>Precio: u$s <strong>${offer.itemOrder.item.precio}</strong></p>
										<p>Pais destino: <strong>${offer.itemOrder.paisDestino}</strong></p>
                                    </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-warn" data-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
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
        <h5 class="modal-title" id="exampleModalLongTitle">Aceptar oferta?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <p>Luego de aceptar, se generar&aacute; una orden de pago via MercadoPago.</p>
      </div>
      <div class="modal-footer">
                	 <input id="confirmButton" type="button" 
	                    class="btn btn-primary" 
	                    value="Aceptar oferta" 
	                    data-title="Aceptar oferta" 
	                    data-message="Aceptando oferta..." 
	                    data-url=""/> 
                    <button type="button" class="btn btn-warn" data-dismiss="modal">Cancelar</button>
                </div>
    </div>
  </div>
</div>
</body>

</html>