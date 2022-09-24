<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/19
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>number</td>
    </tr>
    <c:forEach items="${empList}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.number}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>