<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/8/2
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>表现层：查询所有账户信息</h1>

    <c:forEach items="${list}" var="account">
        ${account.name}<br>
        ${account.money}<br>
    </c:forEach>

</body>
</html>
