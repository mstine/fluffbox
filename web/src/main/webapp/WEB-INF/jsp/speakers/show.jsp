<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Browse Speakers</title>
    <link rel="stylesheet" href="<c:url value="/css/blueprint/screen.css"/>" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<c:url value="/css/blueprint/print.css"/>" type="text/css" media="print">
    <!--[if lt IE 8]>
    <link rel="stylesheet" href="<c:url value="/css/blueprint/ie.css"/>" type="text/css" media="screen, projection">
    <![endif]-->
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>" type="text/css" media="screen, projection">
</head>

<body>
<div class="main container">
    <div class="header span-24 last">
        <h2><img src="<c:url value="/images/fluffbox-logo.jpg"/>"/></h2>
    </div>
    <div class="speakers">
        <div class="speaker span-8">
            <img src="<c:url value="${speaker.imagePath}"/>"/>
        </div>
            <h2>${speaker.firstName} ${speaker.lastName}</h2>
            <p>${speaker.bio}</p>
        </div>
        <div class="footer span-24 last">
            Copyright &copy; 2010 Fluffbox Inc.
        </div>
    </div>
</body>
</html>