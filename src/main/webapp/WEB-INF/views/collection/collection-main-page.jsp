<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MyCollections</title>
</head>
<body>

<div>WELCOME ${user.email}</div>
<br>
<a href="/collection/add">ADD COLLECTION</a><br>
COLLECTIONS:<br>
<br>
<c:choose>
    <c:when test="${empty collections}">
        NO COLLECTIONS YET, ADD NEW ONE
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>No.</th>
                <th>Collection name</th>
                <th>Collection description</th>
            </tr>
            <c:forEach items="${collections}" var="col" varStatus="loop">
                <tr>
                    <td>${loop.index}</td>
                    <td>${col.name}</td>
                    <td>${col.description}</td>
                    <td><a href="/collection/edit?id=${col.id}">EDIT</a></td>
                    <td><a href="/collection/delete?id=${col.id}">DELETE</a></td>
                    <td><a href="/items/add?colId=${col.id}">ADD ITEMS</a></td>
                    <td><a href="/items/showItems/${col.id}">SHOW ITEMS</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
