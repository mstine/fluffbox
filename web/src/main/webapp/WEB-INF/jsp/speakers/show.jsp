<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Browse Speakers</title>
</head>

<body>
<div class="speakers">
    <div class="speaker span-8">
        <img src="<c:url value="${speaker.imagePath}"/>"/>
    </div>
    <h2>${speaker.firstName} ${speaker.lastName}</h2>

    <p>Find this speaker!</p>

    <p>

    <form action="<c:url value="/kiosks/find.html"/>" method="post">
        <input type="hidden" name="speakerId" value="${speaker.id}"/>
        ZIP: <input type="text" name="zip"/> <input type="submit" value="Find!"/>
    </form>
    </p>
    <p>${speaker.bio}</p>
</div>
</body>
</html>