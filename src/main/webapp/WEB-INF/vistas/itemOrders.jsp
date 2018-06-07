<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de pedidos</title>
<!-- 	    <link href="../css/bootstrap.min.css" rel="stylesheet" > -->
<!-- 	    <link href="../css/bootstrap-theme.min.css" rel="stylesheet"> -->
	    
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	    
	    <link href="../css/main.css" rel="stylesheet"> 
	    
	</head>
	<body>
	<!-- HEADER: NAVBAR -->
		<header>
        <div class="container-fluid">
            <div class="row navbar">
                <div class="col-sm-12 col-md-3">
                <a href="<c:url value = "/"/>"><img src=".././img/logo.png" class="logo" alt="Logo"></a>
                </div>
                <div class="col-sm-12 col-md-9">
                    <div class="col col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value = "/order"/>">Crear un pedido</a>
                    </div>
                    <div class="col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="#"><strong>Gana dinero con nosotros</strong></a>
                    </div>
                    <div class="col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value = "/login"/>" >Iniciar sesion</a>
                    </div>
                    <div class="col-sm-12 col-md-3 nav-item">
                        <a class="nav-link" href="<c:url value = "/signup"/>">Registrarse</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <c:if test = "${mensajeError != ' '}">
<%-- 		<div class="alert alert-danger" role="alert">${mensajeError}</div> --%>
		${mensajeError}
  	</c:if>
  
    <div class="container">
      <div class="row">
	   		<c:forEach var="order" items="${itemOrders}">
	   			
	   		  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22348%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20348%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_163db429534%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_163db429534%22%3E%3Crect%20width%3D%22348%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22116.45000076293945%22%20y%3D%22120.3%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
			      
			      <div class="caption">
			        <h3><c:out value="${order.item.nombre}"/></h3>
			        <p><c:out value="${order.description}"/></p>
			        <p class="text-right">Cant: <strong><c:out value="${order.item.cantidad}"/></strong> Precio: u$s <strong><c:out value="${order.item.precio}"/></strong></p>
			        <p>
				        <a href="<c:url value="/offer/${order.id }"/>" class="btn btn-primary" role="button" style="width:40%;">Ofertar</a> 
				        <a href="<c:url value="/itemOrder/${order.id }"/>" class="btn btn-default" role="button">Detalle</a>
			        </p>
			      </div>
			      
			    </div>
			  </div>

   			</c:forEach>

   		</div>
    </div>



            
            


		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="../../../js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>