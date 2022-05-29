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
  <title>检测结果查询</title>
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container container-default">
  <h1>检测结果查询</h1>
  <div class="well">
    <form action="detectedManager.do" method="post">
      <div class="form-group row">
        <label class="col-2 col-form-label">学号</label>
        <div class="col-10">
          <input class="form-control" type="text" name="student_id" id="student_id"
                 placeholder="student_id">
        </div>
      </div>
      <div>
        <button type="submit" class="btn btn-primary">查询</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>
