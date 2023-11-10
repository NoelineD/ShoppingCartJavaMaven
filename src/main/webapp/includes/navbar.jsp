   <nav class="navbar navbar-expand-lg ftco_navbar ftco-navbar-light" id="ftco-navbar">
		    <div class="container">
		    	<a class="navbar-brand" href="index.html">MyDigitalShop</a>
		      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="fa fa-bars"></span> Menu
		      </button>
		      <div class="collapse navbar-collapse" id="ftco-nav">
		        <ul class="navbar-nav ml-auto">
							<li class="nav-item"><a href="index.jsp" class="nav-link">Home</a></li>
		        	<li class="nav-item"><a href="cart.jsp" class="nav-link">Cart</a></li>
		        	<li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
		        	<li class="nav-item dropdown position-static">
	              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">User</a>
	              <div class="dropdown-menu p-4" aria-labelledby="dropdown04">
	              	<div class="row"> 
	
	              		
	              		<div class="col-md-3 d-none d-md-block">
	              			<a href="#" class="img" style="background-image: url(images/img-1.jpg);"></a>
	              			<div class="text">
	              				<h3><a href="#">Computers</a></h3>
	              				<span>Digital</span>
	              			</div>
	              		</div>
	              		<div class="col-md-3 d-none d-md-block">
	              			<a href="#" class="img" style="background-image: url(images/img-2.jpg);"></a>
	              			<div class="text">
	              				<h3><a href="#">Keyboards</a></h3>
	              				<span>Digital</span>
	              			</div>
	              		</div>
	              		<div class="col-md-3 d-none d-md-block">
	              			<a href="#" class="img" style="background-image: url(images/img-3.jpg);"></a>
	              			<div class="text">
	              				<h3><a href="#">Headphones</a></h3>
	              				<span>Digital</span>
	              			</div>
						           			
	              		</div>
	              	<div class="col-md-3">
			                
			             <% 
			              // Récupérez la valeur de isAdmin depuis la portée de la requête
    						if (auth != null) { 
        						if (isAdmin) { %>  
									<a class="dropdown-item" href="log-out">LogOut</a>
            						<a class="dropdown-item" href="createproduct.jsp">Create Product</a>
            						<a href="index.jsp" class="dropdown-item">Modify Product</a>
        						<% } else { %>
            						<a class="dropdown-item" href="log-out">Logout</a>
            						<a class="dropdown-item" href="orders.jsp">My Orders</a>
        						<% }
    							} else {  %>
        							<a class="dropdown-item" href="login.jsp">LogIn</a>
    							<% } %>
			                
	                </div> 
	              	</div>
	              </div>
	            </li>
		        </ul>
		      </div>
		    </div>
		  </nav>
    <!-- END nav -->
    
<!--       <a class="nav-link" href="log-out">Logout</a> --> -->
