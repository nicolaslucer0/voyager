<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page='fragments/imports.jsp' />
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
                        <p class="card-text"> ${order.item.descripcion} </p>
                        <p>Cant:<strong>${order.item.cantidad}</strong></p>
                        <p>Precio: u$s <strong>  ${order.item.precio}</strong></p>
                        <p>Pais destino: <strong>${order.paisDestino}</strong></p>
                        <p>Estado: <strong>${order.estadoEntrega}</strong></p> 
                    </div>
                    <div class="card-footer text-muted">
                    <c:if test="${order.estadoRecibo ne 'ENTREGADO'}">
					    <button type="button" data-url="<c:url value="/order/change/status/${order.id}/"/>" data-id="${order.id}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Cambiar estado</button>
                   	</c:if>
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
                    <h5 class="modal-title" id="exampleModalLongTitle">Cambiar estado de entrega
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Cambiar el estado notifica al comprador de donde esta su producto.</p>
                    <select id="selectEstado">
                    	<option>COMPRANDO</option>
                    	<option>VIAJANDO</option>
                    	<option>ENTREGADO</option>
                    </select>
                </div>
                <div class="modal-footer">
                    <input id="cambiarEstado" type="button" 
                    class="btn btn-primary" 
                    value="Cambiar estado" 
                    data-title="Estado"  
                    data-message="Se ha cambiado el estado." 
                    data-url=""> 
                    <button type="button" class="btn" data-dismiss="modal">Volver</button>
                </div>
            </div>
        </div>
    </div>

</body>

</html>