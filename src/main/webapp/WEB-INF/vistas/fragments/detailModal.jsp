<!-- Modal -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade detail" id="detailModal${order.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modal${ order.id}">Detalles</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
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
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warn" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>