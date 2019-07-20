<%@page import="java.time.LocalDateTime"%>
<%@page import="sms.pojo.Student"%>
<%@page import="sms.pojo.Record"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>操作记录</title>
</head>
<style>
* {
	background-color: black;
	color: greenyellow;
}

li {
	/* 等宽字体 */
	font-family: Consolas, Monaco, monospace;
	border: solid 1px red;
}
</style>
<body>
	<%
		if (session.getAttribute("student") != null) {
	%>
	<ol>
		<%
			Object records = application.getAttribute("op_record");
				if (records != null) {
					for (Record record : (List<Record>) records) {
		%>
		<li>时间：<%
			LocalDateTime time = record.getTime();
		%><%=time.toLocalDate()%>&nbsp;<%=time.toLocalTime()%>&emsp;&emsp;类型：<%=record.getType().name()%><br />
			账号：<%=record.getStudentAccount()%> <%
 	if (record.getParameter() != null) {
 %>&emsp;&emsp;参数：<%=record.getParameter()%><%
 	}
 %>
		</li>
		<%
			}
				}
		%>
	</ol>
	<%
		}
	%>
</body>
</html>