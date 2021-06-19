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
        <a href="/collection/show">GO BACK</a>
    </c:when>
    <c:otherwise>
        <c:forEach var="entry" items="${itemCollection}">
            <h1>${entry.key}</h1>
            <table>
                <tr>
                    <th>No.</th>
                    <th>Item name</th>
                    <th>Item description</th>
                    <th>Status date</th>
                </tr>
                <c:forEach var="entryValues" items="${entry.value}" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <td>${entryValues.name}</td>
                        <td>${entryValues.description}</td>
                        <td>${entryValues.date}</td>
                        <td><a href="/items/edit?id=${entryValues.id}">EDIT</a></td>
                        <td><a href="/items/delete?id=${entryValues.id}&colId=${collectionId}">DELETE</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:forEach>
        <br>
        <a href="/items/add?colId=${collectionId}">ADD NEW ONE</a><br>
        <a href="/collection/show">GO BACK</a>
    </c:otherwise>
</c:choose>
</body>
</html>
