<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<jsp:include page='fragments/imports.jsp' />
</head>
<body style="text-align:center;">
<jsp:include page='fragments/navbar.jsp' />

    <h1>Operaci&oacute;n realiazada con &eacute;xito !</h1>
    <a href="<c:url value="/"/>">Volver al home</a>
</body>
</html>