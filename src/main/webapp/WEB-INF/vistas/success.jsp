<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/main.css" rel="stylesheet">
    <title>Error.</title>
</head>
<body style="text-align:center;">
    <h1>Error ${errorCode}</h1>
    ${errorMsg}
</body>
</html>