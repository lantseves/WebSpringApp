<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 14.12.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
        <title>Edit Order</title>
</head>
<body>
        <form action="${order.id}?form"  method="POST">

                <input type="hidden" name="id" value="${order.id}">
                <label for="name">Name</label>
                <input type="text" name="name" id="name" value="${order.name}">

                <label for="date">Date</label>
                <input type="text" name="date" id="date" readonly value="${order.dateOrdered}">

                <label for="salary">Salary</label>
                <input type="text" name="salary" id="salary" value="${order.salary}">

                <label for="statusOrder">Status</label>
                <select name="statusOrder"  id="statusOrder">
                        <c:forEach items="${statusOrder}" var="option">
                                <option value="${option}">${option}</option>
                        </c:forEach>
                </select>

                <input type="submit" value="Edit order">
        </form>

        <h3>List dishes</h3>
        </p>
        <c:forEach var="dish" items="${order.dishes}">
                <p>
                        <label for="title${dish.id}">Recipe:</label>
                        <input type="text" name="title" id="title${dish.id}" readonly value="${dish.name}"/>

                        <label for="salary${dish.id}">Salary:</label>
                        <input type="text" name="salary" id="salary${dish.id}" readonly value="${dish.salary}"/>

                        <label for="quantity${dish.id}">quantity:</label>
                        <input type="text" name="quantity" id="quantity${dish.id}" readonly value="${dish.quantity}"/>
                </p>
        </c:forEach>
</body>
</body>
</html>
