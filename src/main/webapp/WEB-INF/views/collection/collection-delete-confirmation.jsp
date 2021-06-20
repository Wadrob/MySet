<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>DELETE YOUR COLLECTION ${collectionToDelete.name}</title>
</head>
<body>
ARE YOU SURE YOU WANT TO DELETE COLLECTION ${collectionToDelete.name}?
<a href="/collection/delete/${collectionToDelete.id}">YES</a>
<a href="/collection/show">NO</a>
</body>
</html>
