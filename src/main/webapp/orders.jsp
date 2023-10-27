<%@ page import="cn.techtutorial.connection.dbConnect"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.techtutorial.model.Cart"%>
<%@ page import="cn.techtutorial.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% User auth = (User) request.getSession().getAttribute("auth");
   if (auth!=null){
	   request.setAttribute("auth",auth);
   }
   
   ArrayList<Cart> cart_list= (ArrayList<Cart>) session.getAttribute("cart-list");
   if(cart_list != null){
   	   request.setAttribute("cart_list", cart_list);
   }
%>
<!DOCTYPE html>
<html>
<head>
<title>Orders Page</title>
<%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<h1>Hello nono </h1>
<%@ include file="includes/footer.jsp" %>
</body>
</html>