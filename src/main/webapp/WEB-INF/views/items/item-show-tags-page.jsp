<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TAGS FOR ITEM - ${item.name}</title>
</head>
<body>
<B>TAGS</B>
<c:choose>
    <c:when test="${empty item.tags}">NO TAGS IN ITEM</c:when>
    <c:otherwise>
        <c:forEach items="${item.tags}" var="tags">
            <b>${tags.name}, </b>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
