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
	<title>添加用户</title>
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
   <div class="container container-default">
	   <h1>添加被测者</h1>
   		<div class="well">
			<form action="insertTestUser.do" method="post">
				<div class="form-group row">
					<label class="col-2 col-form-label">姓名</label>
					<div class="col-10">
						<input class="form-control" type="text" name="name" id="name" value="${name}"
							placeholder="name">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label">学号</label>
					<div class="col-10">
						<input class="form-control" type="text" name="student_id" id="student_id" value="${studentId}"
							   placeholder="student_id">
					</div>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">确认添加</button>
					<a href="javascript:void(0);" class="btn btn-primary" role="button" onclick="cancel()">取消</a>
				</div>
				<script type="text/javascript">
					function cancel() {
						window.location.href ="<%=request.getContextPath()%>/collectionManager.do?action=list";
					}
				</script>
			</form>
		</div>
	</div>
</body>
</html>
