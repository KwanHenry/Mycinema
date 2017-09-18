<%@page import="dao.impl.CategoryDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,entity.*,dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	CategoryDao cateImpl = new CategoryDaoImpl();
	List<Category> list = cateImpl.getAll();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%
			for (Category c : list) {
		%>
		<li><a href="movies.jsp?cid=<%=c.getId() %>&name=<%=c.getName()%>" ><%=c.getName()%></a></li>
		<%
			}
		%>
	</ul>
</body>
</html>