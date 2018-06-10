<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<jsp:include page='fragments/imports.jsp' />
</head>
<body style="text-align:center;">
    <h1>Error ${errorCode}</h1>
    ${errorMsg}
</body>
</html>