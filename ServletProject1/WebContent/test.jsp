<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요. JSP입니다.
	
<%
	String name = request.getParameter("name");
	out.println(name);
%>
<br>
<%=name %>
<br>
<% out.println("반가워요."); %>
<jsp:include page="testprint.jsp"></jsp:include>
<%
	//response.sendRedirect("http://www.naver.com");
	String test2Value = config.getInitParameter("test2Value");
	out.println(test2Value);
%>

</body>	
</html>