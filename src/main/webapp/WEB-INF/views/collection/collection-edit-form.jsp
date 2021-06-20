<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> EDIT COLLECTION ${collectionEdit.id} - for ${collectionEdit.user.email}</title>
</head>
<body>
<form:form method="post" modelAttribute="collectionEdit">
    <form:input path="name"/>
    <form:errors path="name"/>
    <form:input path="description"/>
    <form:errors path="description"/>
    <input type="submit" value="UPDATE">
</form:form>

</body>
</html>
