<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page='fragments/imports.jsp' />
    <script type="text/javascript" src="<c:url value="//js/showConfirm.js"/>"></script>
    <script type="text/javascript" src="<c:url value="//js/showDetail.js"/>"></script>
</head>

<body>
    <jsp:include page='fragments/navbar.jsp' />

    <c:if test="${itemOrders eq null}">
        <div class='alert alert-danger' role='alert'>Usted no ha realizado ningun pedido.</div>
    </c:if>
    <div class="container">
        <div class="d-flex align-content-around flex-wrap">
            <!-- CARDS -->
            <c:forEach var="order" items="${itemOrders}">
                <div class="card card-item d-flex align-items-stretch"> 
                    <img class="card-img-top" alt="${order.item.nombre}" src="${order.item.imagen}">
                    <div class="card-body">
                        <h5 class="card-title">${order.item.nombre}</h5>
                        <p class="card-text"> ${order.item.descripcion}" </p>
                        <p>Cant:<strong>${order.item.cantidad}</strong></p>
                        <p>Precio: u$s <strong>  ${order.item.precio}</strong></p>
                        <p>Pais destino: <strong>${order.paisDestino}</strong></p>
                    </div>
                    <div class="card-footer text-muted">
					    <button type="button" data-url="<c:url value="/order/cancel/${order.id}"/>" data-id="${order.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Cancelar</button>
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
                                    <img class="card-img-top" alt="${order.item.nombre}" src="${order.item.imagen}">
                                    <div class="card-body">
                                        <h5 class="card-title">${order.item.nombre}</h5>
                                        <p class="card-text"> ${order.item.descripcion}" </p>
                                        <p>Cant:<strong>${order.item.cantidad}</strong></p>
                                        <p>Precio: u$s <strong>  ${order.item.precio}</strong></p>
                                        <p>Pais destino: <strong>${order.paisDestino}</strong></p>
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
    
    <!-- Modal Oferta -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Cancelar pedido?
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Al cancelar, se eliminar&aacute; su pedido y todas sus ofertas asociadas.</p>
                </div>
                <div class="modal-footer">
                    <a type="button" class="btn btn-primary" href="">Cancelar</a>
                    <button type="button" class="btn btn-warn" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>

</body>

</html>