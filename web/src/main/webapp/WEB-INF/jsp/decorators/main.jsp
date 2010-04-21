<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <title>Fluffbox - <decorator:title default="Welcome!"/></title>
    <link rel="stylesheet" href="<c:url value="/css/blueprint/screen.css"/>" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<c:url value="/css/blueprint/print.css"/>" type="text/css" media="print">
    <!--[if lt IE 8]>
    <link rel="stylesheet" href="<c:url value="/css/blueprint/ie.css"/>" type="text/css" media="screen, projection">
    <![endif]-->
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>" type="text/css" media="screen, projection">
    <link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>" type="image/x-icon"/>
    <decorator:head/>
</head>

<body>
<div class="main container">
    <div class="header span-24 last">
        <a href="<c:url value="/"/>"><img src="<c:url value="/images/fluffbox-logo.jpg"/>"/></a>
    </div>
    <decorator:body/>
    <div class="footer span-24 last">
        Copyright &copy; 2010 Fluffbox Inc.
    </div>
</div>
</body>
</html>