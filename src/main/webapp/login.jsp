<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head>
<title>Login page</title>
<%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div class="container">
	<div class="card mx-auto w-50 my-5">
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