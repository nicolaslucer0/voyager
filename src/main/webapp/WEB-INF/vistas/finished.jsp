<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='fragments/imports.jsp' />
<script type="text/javascript" src="<c:url value="//js/showDetail.js"/>"></script>

</head>
<body>
	<jsp:include page='fragments/navbar.jsp' />
	<c:if test="${myOffers eq null}">
		<div class='alert alert-danger centered' style="text-align: center; width: 80%; margin:20% auto 0 auto;" role="alert">Usted no ha realizado ninguna oferta.</div> 
  	</c:if>
 	<div class="container">
		<div class="d-flex align-content-around flex-wrap">
				<div class='alert alert-success centered' style="text-align: center; width: 80%; margin:20% auto 0 auto;" >
					<h2>Excelente, El pedido se ha entregado con éxito!</h2>
					<p> Tanto el comprador como el viajero han confirmado la entrega</p>
					<h5>Gracias por utilizar Voyager.</h5>
				</div>
		</div>
	</div>
</body>

</html>