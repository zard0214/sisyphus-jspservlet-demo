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
	<title>检测结果显示</title>
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
   <div class="container container-default">
	   <h1>检测结果显示</h1>
   		<div class="well">
			<form action="insertTestUser.do" method="post">
				<div class="form-group row">
					<label class="col-2 col-form-label">采样结果</label>
					<div class="col-10">${samples.resultStr}
<%--						<label class="form-control" type="text" name="result" id="result" value=""--%>
<%--							   placeholder="result">--%>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label">姓名</label>
					<div class="col-10">${user.name}
<%--						<label class="form-control" type="text" name="name" id="name" value="${user.name}"--%>
<%--							   placeholder="name">--%>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label">采样时间</label>
					<div class="col-10">${samples.gmtCreatedStr}
<%--						<label class="form-control" type="text" name="gmtCreated" id="gmtCreated" value="${samples.gmtCreatedStr}"--%>
<%--							placeholder="gmtCreated">--%>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label">结果提交时间</label>
					<div class="col-10">${samples.gmtModifiedStr}
<%--						<label class="form-control" type="text" name="gmtModified" id="gmtModified" value=""--%>
<%--							   placeholder="gmtModified">--%>
					</div>
				</div>
				<div>
					<a href="javascript:void(0);" class="btn btn-primary" role="button" onclick="cancel()">取消</a>
				</div>
				<script type="text/javascript">
					function cancel() {
						window.location.href ="<%=request.getContextPath()%>/detectedManager.do";
					}
				</script>
			</form>
		</div>
	</div>
</body>
</html>
