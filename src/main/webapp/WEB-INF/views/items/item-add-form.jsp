<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ADD NEW ITEM FOR YOUR COLLECTION</title>
</head>
<body>
<form:form method="post" modelAttribute="item">
    <form:input path="name" placeholder="name"/><br>
    <form:input path="description" placeholder="description"/><br>
    <form:input path="status" placeholder="status"/><br>
    <input type="hidden" name="colId" value="${colId}">
    <input type="submit" value="Create Item">
</form:form>
</body>
</html>
