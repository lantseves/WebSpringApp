<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 11.01.2020
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value = "recipes/" var="recipeUrl"/>
<html>
<head>
    <title>Recipes</title>
</head>
<body>
    <h2>Recipes</h2>
    <a href="?form">Add new recipe</a>
    <p>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>salary</th>
        </tr>
        <c:forEach var="recipe" items="${recipes}">
            <tr>
                <td>${recipe.id}</td>
                <td>${recipe.name}</td>
                <td>${recipe.description}</td>
                <td>${recipe.salary}</td>
                <td>
                    <a href="${recipeUrl}${recipe.id}?form">edit</a>
                    <a href="${recipeUrl}/delete/${recipe.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
