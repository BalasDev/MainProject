<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<ol>
    <c:forEach items="${files}" var="file">
        <li>${file}</li>
    </c:forEach>
</ol></h1>
</body>
</html>