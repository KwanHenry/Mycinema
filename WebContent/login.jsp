<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	padding: 10px;
}
</style>
</head>
<body>
	<form action="check-login.jsp" method="post">
		<fieldset>
			<div>
				<label class="fieldname">用户名：</label> <input type="text"
					name="username"
					value='<%=request.getParameter("username") == null ? "" : request.getParameter("username")%>' />
			</div>
			<div>
				<label class="fieldname">密码：</label> <input type="password"
					name="password" />
			</div>
			<div>
				<label class="fieldname">登陆：</label> <input type="submit"
					name="login" value="登陆" />
			</div>
			<div>
				<%
					if (request.getAttribute("Error") != null) {
				%>
				<label><%=request.getAttribute("Error")%></label>
				<%
					}
				%>
			</div>
		</fieldset>
	</form>
</body>
</html>