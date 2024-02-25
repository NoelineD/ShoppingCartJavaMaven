package com.ecommerce.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ecommerce.connection.dbConnect;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.Order;
import com.ecommerce.model.User;

public class MyOrders extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'utilisateur authentifié depuis la session
        User auth = (User) request.getSession().getAttribute("auth");
        if (auth == null) {
            // Rediriger vers la page de connexion si l'utilisateur n'est pas authentifié
            response.sendRedirect("login.jsp");
            return;
        }

        // Déclaration de la variable de connexion à la base de données
        Connection connection = null;

        try {
            // Obtenir la connexion à la base de données
            try {
				connection = dbConnect.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            // Récupérer les commandes de l'utilisateur à partir de la base de données
            OrderDao orderDao = new OrderDao(connection);
            List<Order> orders = orderDao.userOrders(auth.getId());

            // je passe les commandes à la page des commandes pour l'affichage
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        } catch (SQLException e) {
     
            e.printStackTrace(); // Imprimer la trace de l'exception pour le débogage
            
            response.getWriter().println("Une erreur est survenue lors de la récupération des commandes. Veuillez réessayer plus tard.");
        } finally {
            // Fermer la connexion à la base de données dans le bloc finally pour assurer sa fermeture même en cas d'exception
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace(); 
                }
            }
        }
    }
    }