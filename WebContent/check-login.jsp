<%@page import="entity.*,dao.*,dao.impl.UserDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	UserDao userdao = new UserDaoImpl();
	User user = userdao.login(username, password);
	if (user != null) {
		response.sendRedirect("login-success.jsp"); // 重定向
	} else {
		request.setAttribute("Error", "用户名或密码有误！");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("login.jsp"); // 重定向
	}
%>