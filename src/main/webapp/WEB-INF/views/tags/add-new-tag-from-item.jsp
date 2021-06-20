<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ADD NEW TAG FOR ${item.name}</title>
</head>
<body>
CHOOSE FROM LIST:<br>
<c:choose>
    <c:when test="${empty tagsList}">
        NO TAGS YET, ADD NEW ONE!<br>
    </c:when>
    <c:otherwise>
        <form:form method="post" modelAttribute="item">
            <form:hidden path="id"/>
            <form:hidden path="name"/>
            <form:hidden path="date"/>
            <form:hidden path="status"/>
            <form:hidden path="collection"/>
            <form:hidden path="description"/>
            <form:checkboxes path="tags" items="${tagsList}" itemLabel="name" itemValue="id"/><br>
            <input type="submit" value="ADD TAGS"><br>
        </form:form>
    </c:otherwise>
</c:choose>

<a href="/tags/addNewTag?userId=${item.collection.user.id}">ADD NEW ONE</a>
</body>
</html>
