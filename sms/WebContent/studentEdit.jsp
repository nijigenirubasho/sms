
<%@page import="sms.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--注意：先获得Student对象 --%>
<%
	Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑学生</title>
</head>
<body>
	<div style="text-align: center;">
		<br>--编辑学生--ID:${student.studentId}<br />
		<form action="<%=request.getContextPath()%>/studentEdit.do"
			method="post">
			<%--hidden type 隐藏 --%>
			<input name="studentId" type="hidden"
				value="<%=student.getStudentId()%>"> 学生名： <input
				name="studentName" value="<%=student.getStudentName()%>" type="text"><br />
			账号名： <input name="studentAccount"
				value="<%=student.getStudentAccount()%>" type="text"><br />
			密码： <input name="studentPwd" value="<%=student.getStudentPwd()%>"
				type="password"><br /> <input value="编辑学生" type="submit"><br />
		</form>
	</div>
</body>
</html>