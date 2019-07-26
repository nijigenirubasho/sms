<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除学生</title>
</head>
<%
	if (session.getAttribute("student") != null) {
%>
<body>
	--删除学生--
	<br />
	<form action="<%=request.getContextPath()%>/studentDelete.do"
		method="post">
		编号：<input name="studentId" type="number" /> <input type="submit"
			value="删除学生" />
	</form>
</body>
<%
	} else {
%>
<jsp:forward page="studentLogin.jsp"></jsp:forward>
<%
	}
%>
</html>