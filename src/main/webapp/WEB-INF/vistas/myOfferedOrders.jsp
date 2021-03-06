<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/mercadoPagoBoton.js"/>"></script>
</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	
	<c:if test="${itemOrders eq null}">
		<div class='alert alert-danger centered' style="text-align: center; width: 80%; margin:20% auto 0 auto;" role='alert'>Nadie ha ofertado tus pedidos por ahora.</div>
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
						<button type="button" data-offer-id="${offer.id}" data-url="<c:url value="/offer/${offer.id}/accept/order/${offer.itemOrder.id}"/>" data-id="${offer.itemOrder.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Aceptar Oferta</button>
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
      <p>Se esta generado el link de pago. Una vez terminado se habilitara el boton</p>
      <p><strong>Medios de pago</strong></p>
      <img style="width: 100%" src="<c:url value="//img/mercadopago.png"/>"> 
      </div>
      <div class="modal-footer">
                	 <input id="btnMercadoPago" type="button" 
	                    class="btn btn-primary disabled" 
	                    value="Aceptar oferta" 
	                    data-title="Aceptar oferta" 
	                    data-message="Aceptando oferta..."
	                    disabled 
	                    data-url=""/> 
                    <button type="button" class="btn btn-warn" data-dismiss="modal">Cancelar</button>
<!--         <a type="button" class="btn btn-primary disabled" disabled href="" id="btnMercadoPago">Pagar en Mercado Pago</a> -->
      </div>
      </div>
    </div>
  </div>
</body>

</html>