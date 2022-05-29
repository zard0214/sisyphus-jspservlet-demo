<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: Magomed
  Date: 06.01.2018
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>登陆</title>
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container container-default">
  <h2>登陆</h2>
  <form action="<%=request.getContextPath()%>/user/login" method="POST">

    <label for="name">
      <p>输入账号:</p>
    </label>
    <input type="text" name="name" id="name"><br>

    <label for="password">
      <p>输入密码:</p>
    </label>
    <input type="text" name="password" id="password"><br>

    <br>
    <br>
    <input type="submit" value="登陆">
  </form>
</div>
</body>
</html>