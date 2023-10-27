package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.techtutorial.model.User;

import cn.techtutorial.connection.dbConnect;
import cn.techtutorial.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
/* @webServlet("/user-login") */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			// on recupere les parametres stockés dans le formulaire
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			out.print(email+password);
			
			try {
		    // creation nouvelle instance dao
				UserDao udao= new UserDao(dbConnect.getConnection());
		
			//	Appelle la méthode UserLogin de UserDao pour vérifier les informations de connexion. La méthode renvoie un objet User.
				User user= udao.UserLogin(email, password);
				
				// si utilisateur existe alors  Stocke l'objet user dans la session de l'utilisateur pour le marquer comme authentifié et renvoie vers index
				if(user != null) {
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("index.jsp");
				}else {
					out.print("user login failed");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
