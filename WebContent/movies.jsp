<%@page import="java.util.*,entity.*,dao.*,dao.impl.MovieDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int categoryId = 0;
	if (request.getParameter("cid") != null && !request.getParameter("cid").isEmpty())
		categoryId = Integer.valueOf(request.getParameter("cid"));
	MovieDao moviedao = new MovieDaoImpl();
	List<Movie> movies = moviedao.getMoviesByCategoryId(categoryId);
	String str = request.getParameter("name");
	System.out.println(str);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%
			for (Movie movie : movies) {
		%>
		<li><%=movie.getTitle()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>