<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ALL TAG FOR USER - ${user.email}</title>
</head>
<body>
<c:choose>
    <c:when test="${empty tags}">
        NO TAG YET, ADD NEW ONE
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
            </tr>
        <c:forEach items="${tags}" var="tag" varStatus="lopp">
            <tr>
                <td>${lopp.index+1}</td>
                <td>${tag.name}</td>
                <td><a href="/tags/deleteItem?tagId=${tag.id}">DELETE TAG</a></td>
            </tr>
        </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<br>
<a href="/tags/addNewTag?userId=${user.id}">ADD NEW TAG</a><br>
<a href="/collection/show">GO TO COLLECTION</a>
</body>
</html>
