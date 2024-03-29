<%@ page import="java.util.*" %>
<%@ page import="com.ecommerce.model.Product" %>
<%@ page import="com.ecommerce.dao.ProductDao" %>
<%@ page import="com.ecommerce.model.User" %>
<%@ page import="com.ecommerce.model.Cart" %>
<%@ page import="com.ecommerce.connection.dbConnect" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<% 
    User auth = (User) request.getSession().getAttribute("auth");
    boolean isAdmin = false; // Initialisez isAdmin � false

    if (auth != null) { 
        request.setAttribute("auth", auth);
        isAdmin = "admin".equals(auth.getRole()); // Mise � jour de la valeur de isAdmin
        request.setAttribute("isAdmin", isAdmin); // Mettez isAdmin dans la port�e de la requ�te pour une utilisation ult�rieure
    }

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
    
    Product product = null; //variable declar� en dehors du bloc sinon non reconnue
    
    String productId = request.getParameter("id");
    if (productId != null) {
        // Convertir productId en entier si n�cessaire
        int productIdInt = Integer.parseInt(productId);
        
        // Utiliser productIdInt pour r�cup�rer les d�tails du produit � modifier
        // r�cup�rer les informations du produit dans la bdd en fonction de l'ID.
        ProductDao productDao = new ProductDao(dbConnect.getConnection());
        product = productDao.getSingleProduct(productIdInt);

        // Placez le produit dans la port�e de la requ�te
        request.setAttribute("product", product);
    } else {
        // G�rez le cas o� aucun ID de produit n'est fourni
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
        <input type="hidden" name="id" value="<%= product.getId() %>">
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