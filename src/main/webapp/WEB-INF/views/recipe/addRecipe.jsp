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
    <title>Add recipe</title>
</head>
<body>
    <form action="?form" method="POST">
        <input type="hidden" name="id" value=0>

        <label for="name">Name</label>
        <input type="text" name="name" id="name">

        <label for="salary">Description</label>
        <input type="text" name="Description" id="description">

        <label for="salary">Salary</label>
        <input type="text" name="salary" id="salary">

        <input type="submit" value="Add new recipe">
    </form>
</body>
</html>
