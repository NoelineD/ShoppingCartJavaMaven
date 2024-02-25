<%@ page import="com.ecommerce.connection.dbConnect"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ecommerce.model.Cart"%>
<%@ page import="com.ecommerce.model.User"%>
<%@ page import="com.ecommerce.model.Order"%>
<%@ page import="com.ecommerce.dao.OrderDao"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
DecimalFormat dcf= new DecimalFormat("#.##");
request.setAttribute("dcf",dcf);
User auth = (User) request.getSession().getAttribute("auth");
boolean isAdmin = false; // Initialisez isAdmin à false

if (auth != null) {
    request.setAttribute("auth", auth);
    isAdmin = "admin".equals(auth.getRole()); // Mise à jour de la valeur de isAdmin
    request.setAttribute("isAdmin", isAdmin); // Mettez isAdmin dans la portée de la requête pour une utilisation ultérieure
}
   
   ArrayList<Cart> cart_list= (ArrayList<Cart>) session.getAttribute("cart-list");
   if(cart_list != null){
   	   request.setAttribute("cart_list", cart_list);
   }
   
   List<Order> orders = (List<Order>) request.getAttribute("orders");
  
%>
<!DOCTYPE html>

<html>

<head>

<title>Orders Page</title>

<%@ include file="includes/head.jsp" %>

</head>

<body>

<%@ include file="includes/navbar.jsp" %>

<div class="container mt-5 mb-5" style="height:600px;">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr> 
					<th scope="col">Date</th> 
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
<%			
 			if(orders != null){
 				for(Order o:orders){ %>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getCategory() %></td>
						<td><%=o.getQuantity() %></td>
						<td><%=dcf.format(o.getPrice()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Cancel</a></td>
					</tr>
		 		 <%}
			 }
			 %>
			
			</tbody>
		</table>
	</div>

<%@ include file="includes/footer.jsp" %>

</body>
</html>