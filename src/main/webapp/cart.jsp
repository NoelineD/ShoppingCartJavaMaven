<%@ page import="java.util.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="com.ecommerce.dao.ProductDao"%>
<%@ page import="com.ecommerce.connection.dbConnect"%>
<%@ page import="com.ecommerce.model.User"%>
<%@ page import="com.ecommerce.model.Cart"%>
<%@ page import="com.ecommerce.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
DecimalFormat dcf= new DecimalFormat("#.##");
request.setAttribute("dcf",dcf);
User auth = (User) request.getSession().getAttribute("auth");
boolean isAdmin = false; // Initialisez isAdmin � false

if (auth != null) {
    request.setAttribute("auth", auth);
    isAdmin = "admin".equals(auth.getRole()); // Mise � jour de la valeur de isAdmin
    request.setAttribute("isAdmin", isAdmin); // Mettez isAdmin dans la port�e de la requ�te pour une utilisation ult�rieure
}
   
   ArrayList<Cart> cart_list= (ArrayList<Cart>) session.getAttribute("cart-list");
   List<Cart> cartProduct = null;
   if(cart_list != null){
	   ProductDao pDao = new ProductDao(dbConnect.getConnection());
	   cartProduct = pDao.getCartProducts(cart_list);
	   double total = pDao.getTotalCartPrice(cart_list);
// 	   adding the cartlist to the request session
   	   request.setAttribute("cart_list", cart_list);
	   request.setAttribute("total", total);
   }
   
%>

<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart page</title>
<%@ include file="includes/head.jsp" %>
<style type="text/css">
.table tbody td{
vertical-align: middle;}
.btn-incre, btn-decre {
box-shadow : none;
font-size:25px;
}
</style>
</head> 
<body> 
 
<%@ include file="includes/navbar.jsp" %>
    
<div class="container-cart mb-5" style="height:1200px; width:100%;">


   <div class="text-center position-relative">
        <div class="align max-height-500">
            <img class="img-banner" src="product-images/banniere.jpg" alt="introImg" style="width:100%; max-height:600px;">
        </div>
        <button class="btn btn-purple transparent-bg position-bottom-left" type="button">Retour aux produits</button>
    </div>


	<div class="cart-content" style="margin-top:115px; margin-left:15px; margin-right:15px;">
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
		
			<tbody>
		<% if(cart_list != null) { 
			for(Cart c:cartProduct){ %>
				<tr>
				<td><%= c.getName() %></td>
				<td><%= c.getCategory() %></td>
				<td><%= dcf.format(c.getPrice()) %></td>
				<td>
				<form action="buy-order-now" method="post" class="form-inline">
				<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
				
				<div class="form-group d-flex justify-content-between w-50">
				
					<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%= c.getId() %>"> <i class="fas fa-minus-square"></i></a>
					<input type="text" name="quantity" class="form-control w-50" value="<%= c.getQuantity() %>" readonly>
					<a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%= c.getId() %>"> <i class="fas fa-plus-square"></i></a>
				
				</div>
				
				<button type="submit" class="btn btn-purple btn-sm">Buy</button>
				
				</form>
				
				</td>
				
				<td><a class="btn btn-dark btn-sm" href="remove-from-cart?id=<%= c.getId() %>">Remove</a></td>
				</tr>
		<%	}
		}%>
		
		</tbody>
	</table>
	
	<div class="d-flex py-3">
		<h3>Total price: $ ${ (total>0)?dcf.format(total):0 }  </h3>
		<a class="mx-3 btn btn-purple" href="cart-check-out">Check Out</a>
	</div>
	</div>
</div>


<%@ include file="includes/footer.jsp" %>

</body>

</html>