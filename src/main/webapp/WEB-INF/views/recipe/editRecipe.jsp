<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 11.01.2020
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit recipe</title>
</head>
<body>
    <form action="${recipe.id}?form" method="POST">

        <input type="hidden" name="id" value="${recipe.id}">

        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${recipe.name}">

        <label for="description">Description</label>
        <input type="text" name="Description" id="description" value="${recipe.description}">

        <label for="salary">Salary</label>
        <input type="text" name="salary" id="salary" value="${recipe.salary}">

        <input type="submit" value="Edit recipe">
    </form>
</body>
</html>
