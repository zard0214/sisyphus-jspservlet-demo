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
	   <h1>删除被测者</h1>
   		<div class="well">
			<form action="insertTestUser.do" method="post">
				<div class="form-group row">
					<label class="col-2 col-form-label">序号</label>
					<div class="col-10">
						<input class="form-control" type="text" name="id" id="id"
							placeholder="id">
					</div>
				</div>
				<div>
					<a href="javascript:void(0);" class="btn btn-primary" role="button" onclick="deleteUser()">确认删除</a>
					<a href="javascript:void(0);" class="btn btn-primary" role="button" onclick="cancel()">取消</a>
				</div>
				<script type="text/javascript">
					function cancel() {
						window.location.href ="<%=request.getContextPath()%>/collectionManager.do?action=list";
					}
				</script>
				<script type="text/javascript">
					function deleteUser() {
						window.location.href ="<%=request.getContextPath()%>/collectionManager.do?action=deleteUser&id=" +
								document.getElementById("id").value;
					}
				</script>
			</form>
		</div>
	</div>
</body>
</html>
