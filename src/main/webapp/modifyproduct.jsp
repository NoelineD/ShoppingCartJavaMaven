<%@ page import="java.util.*" %>
<%@ page import="cn.techtutorial.model.Product" %>
<%@ page import="cn.techtutorial.model.User" %>
<%@ page import="cn.techtutorial.model.Cart" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<% 
    User auth = (User) request.getSession().getAttribute("auth");
    boolean isAdmin = false; // Initialisez isAdmin à false

    if (auth != null) { 
        request.setAttribute("auth", auth);
        isAdmin = "admin".equals(auth.getRole()); // Mise à jour de la valeur de isAdmin
        request.setAttribute("isAdmin", isAdmin); // Mettez isAdmin dans la portée de la requête pour une utilisation ultérieure
    }

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
    
    
    String productId = request.getParameter("id");
    if (productId != null) {
        // Convertissez productId en entier si nécessaire
        int productIdInt = Integer.parseInt(productId);
        
        // Utilisez productIdInt pour afficher les détails du produit à modifier
        // Vous pouvez interagir avec la base de données pour récupérer les informations du produit en fonction de l'ID.
    } else {
        // Gérez le cas où aucun ID de produit n'est fourni
        out.println("Product ID is missing.");
    }
    
%>

<!DOCTYPE html>
<html>
<head>
    <title>Modify Product</title>
    <%@ include file="includes/head.jsp" %>
</head>
<body>
    <%@ include file="includes/navbar.jsp" %>
    <div class="container mt-5 mb-5" style="height:600px;">
        <h2>Modify Product</h2>
        <form action="modify-product" method="post">
            <div class="form-group">
                <label for="name">Product Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= product.getName() %>" required>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" class="form-control" id="category" name="category" value="<%= product.getCategory() %>" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" value="<%= product.getPrice() %>" required>
            </div>
            <div class="form-group">
                <label for="image">Image URL:</label>
                <input type="text" class="form-control" id="image" name="image" value="<%= product.getImage() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Modify Product</button>
        </form>
    </div>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>