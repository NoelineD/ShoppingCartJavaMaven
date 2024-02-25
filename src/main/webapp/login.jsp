<%@ page import="java.util.*"%>
<%@ page import="com.ecommerce.model.User"%>
<%@ page import="com.ecommerce.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% User auth = (User) request.getSession().getAttribute("auth");
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
    
    %>
<!DOCTYPE html>
<html> 
<head>
<title>Login page</title>
<%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>

<div class="container mb-5 d-flex justify-content-center align-items-center" style="height:500px;">
	<div class="card mx-auto w-50">
		<div class="card-header text-center">User Login</div>

		<div class="card-body">
		
			<form action="user-login" method="post" >
		
				<div class="form-group">
					<label for="login-email">Email Address</label>
					<input type="text" class="form-control" name="login-email" placeholder="Enter your email" required>
				</div>
		
				<div class="form-group">
					<label for="login-password">Password</label>
					<input type="text" class="form-control" name="login-password" placeholder="******" required>
				</div>
		
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Validate</button>
				</div>
				
			</form>
			
		</div>
	</div>
</div> 
<%@ include file="includes/footer.jsp" %>
</body>
</html>