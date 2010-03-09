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
        <c:forEach items="${speakers}" var="speaker" varStatus="rowCounter">
            <c:choose>
                <c:when test="${rowCounter.count % 3 == 0}">
                    <div class="speaker span-8 last">
                </c:when>
                <c:otherwise>
                    <div class="speaker span-8">
                </c:otherwise>
            </c:choose>
            <img src="<c:url value="${speaker.imagePath}"/>"/><br/>
            <a href="<c:url value="/speakers/show.html?id=${speaker.id}"/>">${speaker.firstName} ${speaker.lastName}</a>
        </div>
        </c:forEach>

        </div>
        <div class="footer span-24 last">
            Copyright &copy; 2010 Fluffbox Inc.
        </div>
    </div>
</body>
</html>