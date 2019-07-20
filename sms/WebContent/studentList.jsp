<%@page import="sms.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!List<Student> students;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息</title>
</head>
<style>
.la {
	background-color: yellow;
}

.lb {
	background-color: grey;
	color: white;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: red;
	font-weight: bold;
}
</style>
<table border="1" style="width: 100%; text-align: center;">
	<tr>
		<th width="15%">序号</th>
		<th>姓名</th>
		<th>账号</th>
		<th width="10%">操作</th>
	</tr>
	<%
		students = (List<Student>) request.getAttribute("students");
		boolean colorSpinner = false;
		if (students != null)
			for (Student student : students) {
	%>
	<tr class=<%=colorSpinner ? "la" : "lb"%>>
		<%
			colorSpinner = !colorSpinner;
		%>
		<td><%=student.getStudentId()%></td>
		<td><%=student.getStudentName()%></td>
		<td><%=student.getStudentAccount()%></td>
		<td><a
			href="<%=request.getContextPath()%>/studentEdit.do?studentId=<%=student.getStudentId()%>">[更新]</a>
			<a
			href="<%=request.getContextPath()%>/studentDelete.do?studentId=<%=student.getStudentId()%>">[删除]</a></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>