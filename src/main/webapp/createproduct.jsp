<%@ page import="java.util.*"%>
<%@ page import="com.ecommerce.model.Product"%>
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
<div class="container mt-5 mb-5" style="height:600px;">
        <h2>Create New Product</h2>
        <form action="create-product" method="post">
            <div class="form-group">
                <label for="name">Product Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" class="form-control" id="category" name="category" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="image">Image URL:</label>
                <input type="text" class="form-control" id="image" name="image" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Product</button>
        </form>
    </div>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>
</body>
</html>