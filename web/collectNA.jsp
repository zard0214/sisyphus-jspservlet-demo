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
	<title>核酸监测样本采集</title>
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>

<body>
   <div class="container container-default">
	   <h1>核酸监测样本采集</h1>
	   <form action="collectionManager.do" method="post">
		   <div class="form-group row">
			   <label class="col-2 col-form-label">试管编号：</label>
			   <div class="col-10">
				   <input class="form-control" type="text" name="tube_number" id="tube_number"
						  placeholder="tube_number">
			   </div>
		   </div>
		   <div class="form-group row">
			   <label class="col-2 col-form-label">学号：</label>
			   <div class="col-10">
				   <input class="form-control" type="text" name="student_id" id="student_id"
						  placeholder="student_id">
			   </div>
		   </div>
		   <h3>被测者列表</h3>
		   <table class="table table-striped">
			   <thead>
			   <tr>
				   <th>id</th>
				   <th>学号</th>
				   <th>姓名</th>
			   </tr>
			   </thead>
			   <tbody>
			   <c:forEach items="${userList}" var="user">
				   <tr>
					   <td><c:out value="${user.id}" /></td>
					   <td><c:out value="${user.studentId}" /></td>
					   <td><c:out value="${user.name}" /></td>
<%--					   <td>--%>
<%--						   <a class="btn btn-primary" role="button" style="padding-left:5px;"--%>
<%--							  href="collectionManager.do?action=delete&userId=<c:out value="${user.id}"/>">删除被测者</a>--%>
<%--					   </td>--%>
				   </tr>
			   </c:forEach>
			   </tbody>
		   </table>
		   <div>
			   <button type="submit" class="btn btn-primary">提交</button>
		   </div>
	   </form>
	   <script type="text/javascript">
		   function addTester() {
			   window.location.href ="<%=request.getContextPath()%>/collectionManager.do?action=insert&student_id=" +
					   document.getElementById("student_id").value;
		   }
		   function deleteTester() {
			   window.location.href ="<%=request.getContextPath()%>/collectionManager.do?action=delete";
		   }
	   </script>
	   <p>
		   <a href="javascript:void(0);" class="btn btn-primary" role="button" onclick="addTester()">添加被测者</a>
		   <a href="javascript:void(0);" class="btn btn-primary" role="button" onclick="deleteTester()">删除被测者</a>
	   </p>
   </div>

</body>
</html>
