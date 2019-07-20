<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加学生</title>
</head>
<style>
#l {
	width: 230px;
	text-align: right;
}
</style>
<%--鉴权操作 --%>
<%
	if (session.getAttribute("student") != null) {
%>
<body>
	--增加学生--
	<br />
	<%
		Object msg = request.getAttribute("student_add_msg");
			if (msg != null) {
	%>
	<%=msg%>
	<%
		}
	%>
	<br />
	<div id="l">
		<form action="<%=request.getContextPath()%>/studentAdd.do"
			method="post">
			学生名：<input name="studentName" type="text"><br /> 账号名：<input
				name="studentAccount" type="text"><br /> 密码：<input
				name="studentPwd" type="password"><br /> <input
				value="增加学生" type="submit"><br />
		</form>
	</div>
	<a href="<%=request.getContextPath()%>/studentList.do">学生列表</a>
</body>
<%
	} else {
%>
<jsp:forward page="studentLogin.jsp"></jsp:forward>
<%
	}
%>
</html>