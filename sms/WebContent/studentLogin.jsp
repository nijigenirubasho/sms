<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<style>
* {
	text-align: center;
}
</style>
<body>
	<%
		Object msg = request.getAttribute("student_login_msg");
		if (msg != null) {
	%>
	<%=msg%>
	<%
		}
		String name = "", pwd = "";
		if (request.getCookies() != null)
			for (Cookie cookie : request.getCookies()) {
				if ("name".equals(cookie.getName())) {
					name = cookie.getValue();
				}
				if ("pwd".equals(cookie.getName())) {
					pwd = cookie.getValue();
				}
			}
	%>
	<form action="<%=request.getContextPath()%>/studentLogin.do"
		method="post">
		账号名：<input name="studentAccount" type="text" value="<%=name%>"><br />
		密码：<input name="studentPwd" type="password" value="<%=pwd%>"><br />
		<input value="学生登陆" type="submit">
	</form>
</body>
</html>