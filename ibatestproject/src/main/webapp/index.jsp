<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello IBA!</title>
    </head>
    <body>
        <c:forEach begin="1" end="${param.x}">
            <h1>Hello IBA!</h1>
        </c:forEach>
    </body>
</html>
