<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="boostrapCSS" value="//css/bootstrap.min.css" />
<c:url var="mainCSS" value="//css/main.css/" />
<c:url var="bootstrapJS" value="//js/bootstrap.min.js" />
<c:url var="jQuery" value="//js/jquery.js" />

<c:url var="select2JS" value="//js/select2/select2.min.js" />
<c:url var="select2CSS" value="//css/select2/select2.min.css" />

<script src="${jQuery}" type="text/javascript"></script>
<script src="${bootstrapJS}" type="text/javascript"></script>
<script src="${select2JS}" type="text/javascript"></script>

<link href="${boostrapCSS}" rel="stylesheet">
<link href="${mainCSS}" rel="stylesheet">
<link href="${select2CSS}" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>${title}</title>
