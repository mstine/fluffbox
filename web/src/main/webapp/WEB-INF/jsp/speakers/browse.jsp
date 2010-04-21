<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Browse Speakers</title>
</head>

<body>
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
</body>
</html>