<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Browse Speakers</title>
</head>

<body>
<div class="speakers span-24 last">
    <h3>Speaker is available at the following kiosks:</h3>
    <ul>
        <c:forEach items="${kiosks}" var="kiosk" varStatus="rowCounter">
            <li>${kiosk.businessName} <a href="<c:url value="/rental/reserve.html?speakerId=${speaker.id}&kioskId=${kiosk.id}"/>">Reserve</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>