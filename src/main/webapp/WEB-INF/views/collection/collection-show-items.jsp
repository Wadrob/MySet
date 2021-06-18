<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SHOW ALL ITEMS</title>
</head>
<body>
<c:choose>
    <c:when test="${empty items}">
        NO ITEMS IN COLLECTION
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>No.</th>
                <th>Item name</th>
                <th>Item description</th>
                <th>Item status</th>
            </tr>
            <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.status}</td>
                <td><a href="">EDIT</a></td>
                <td><a href="">DELETE</a></td>
            </tr>
            </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
