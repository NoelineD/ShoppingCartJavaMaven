<%@ page import="cn.techtutorial.connection.dbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to shopping cart</title>
<%@ include file="includes/head.jsp" %>
</head>

<body>
<%@ include file="includes/navbar.jsp" %>

<% out.print(dbConnect.getConnection()); %>

<%@ include file="includes/footer.jsp" %>
</body>
</html>