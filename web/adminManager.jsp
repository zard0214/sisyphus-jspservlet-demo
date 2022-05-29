<%--
  Created by IntelliJ IDEA.
  User: zard
  Date: 27/05/2022
  Time: 04:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>用户管理页面</title>
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
  <body>
  <div class="container container-default">
    <h1>用户管理页面</h1>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>id</th>
        <th>姓名</th>
        <th>类型</th>
        <th>学号</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${userList}" var="user">
        <tr>
          <td><c:out value="${user.id}" /></td>
          <td><c:out value="${user.name}" /></td>
          <td><c:out value="${user.typeName}" /></td>
          <td><c:out value="${user.studentId}" /></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <p>
      <a href="adminManager.do?action=insert" class="btn btn-primary" role="button">添加用户</a>
    </p>
  </div>
  </body>
</html>
