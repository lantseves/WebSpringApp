<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 25.12.2019
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Order</title>
</head>
<body>
    <form action="?form" method="POST">
        <p>
            <label for="name">Name order</label>
            <input type="text" name="name" id="name" value="" size="25" />
        </p>
        <p>
            <h3>List menu</h3>
        </p>
        <c:forEach var="recipe" items="${recipes}">
            <p>
                <label for="title${recipe.id}">Recipe:</label>
                <input type="text" name="title" id="title${recipe.id}" readonly value="${recipe.name}"/>

                <label for="salary${recipe.id}">Salary:</label>
                <input type="text" name="salary" id="salary${recipe.id}" readonly value="${recipe.salary}"/>

                <label for="quantity${recipe.id}">quantity:</label>
                <input type="text" name="quantity" id="quantity${recipe.id}" value="0"/>

                <input type="hidden" name="recipe" value="${recipe.id}">
            </p>
        </c:forEach>

        <input type="submit" value="OK" />
        <input type="reset" value="Reset" />
    </form>
</body>
</html>
