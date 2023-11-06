<%@ page import="java.util.List"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.techtutorial.connection.dbConnect"%>
<%@ page import="cn.techtutorial.model.User"%>
<%@ page import="cn.techtutorial.model.Product"%>
<%@ page import="cn.techtutorial.model.Cart"%>
<%@ page import="cn.techtutorial.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
User auth = (User) request.getSession().getAttribute("auth");
boolean isAdmin = false; // Initialisez isAdmin à false

if (auth != null) {
    request.setAttribute("auth", auth);
    isAdmin = "admin".equals(auth.getRole()); // Mise à jour de la valeur de isAdmin
    request.setAttribute("isAdmin", isAdmin); // Mettez isAdmin dans la portée de la requête pour une utilisation ultérieure
}
  
ProductDao pd= new ProductDao(dbConnect.getConnection());
   
List<Product> products = pd.getAllProducts();
   
ArrayList<Cart> cart_list= (ArrayList<Cart>) session.getAttribute("cart-list");
   if(cart_list != null){
   	   request.setAttribute("cart_list", cart_list);
   }
%>
<!DOCTYPE html>
<html>
<head> 
<title>Welcome to shopping cart</title>
<%@ include file="includes/head.jsp" %>
</head>

<body >
<%@ include file="includes/navbar.jsp" %>

<div class="container">

<div class="card-header my-3">All products</div>
	<div class="row">
<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">

			<div class="card w-100" style="width: 18rem;">
  				<img class="card-img-top" src="product-images/<%= p.getImage() %>" alt="Card image cap">
    				<div class="card-body">
    					<h5 class="card-title"><%= p.getName() %></h5>
    	 				<h6 class="price"><%= p.getPrice() %></h6>
    		 			<h6 class="category"><%= p.getCategory() %></h6>
    			
    						<div class="mt-3 justify-content-between d-flex">
    						
    						<% if (isAdmin) { %>
    						
                            <a href="modify-product?id=<%= p.getId() %>" class="btn btn-primary">Modify</a>
                    		
                    		<% } else { %>
   			    			<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a>
   			    			<a href="order-now?quantity=1&id=<%= p.getId() %>" class="btn btn-danger">Buy now</a>
   			    			<% } %>
   			                </div>
   	 				</div>
  			</div>
  	    </div>
<%
		}
			} else {
			out.println("There is no products");
			}
	    %>
	</div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>