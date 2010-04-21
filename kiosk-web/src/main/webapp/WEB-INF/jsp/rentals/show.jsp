<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Rentals Received</title>
</head>

<body>
<div class="speakers span-24 last">
    <h3>The following rental messages have been received by the kiosk:</h3>
    <ul>
        <c:forEach items="${rentals}" var="rental" varStatus="rowCounter">
            <li>${rental}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>