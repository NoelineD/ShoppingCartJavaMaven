package com.ecommerce.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ecommerce.connection.dbConnect;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Order;
import com.ecommerce.model.User;

/**
 * Servlet implementation class BuyOrderNowServlet
 */


public class BuyOrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = new Date();

	            User auth = (User) request.getSession().getAttribute("auth");

	            if (auth != null) {
	                String productId = request.getParameter("id");
	                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
	                if (productQuantity <= 0) {
	                	productQuantity = 1;
	                }
	                Order orderModel = new Order();
	                orderModel.setId(Integer.parseInt(productId));
	                orderModel.setUserId(auth.getId());
	                orderModel.setQuantity(productQuantity);
	                orderModel.setDate(formatter.format(date));

	                OrderDao orderDao = new OrderDao(dbConnect.getConnection());
	                boolean result = orderDao.insertOrder(orderModel);
	                if (result) {
	                	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
	                	if (cart_list != null) {
	                	    Iterator<Cart> iterator = cart_list.iterator();
	                	    while (iterator.hasNext()) {
	                	        Cart c = iterator.next();
	                	        if (c.getId() == Integer.parseInt(productId)) {
	                	            iterator.remove();
	                	            break;
	                	        }
	                	    }
	                	}
	                    // Retrieve the list of orders and set it as a request attribute
	                	OrderDao OrderDao = new OrderDao(dbConnect.getConnection());
	                	List<Order> orders = OrderDao.getAllOrders(); // Change the type to List<Order>
	                	request.setAttribute("orders", orders);
	                    
	                    // Forward to the orders.jsp page
	                    RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
	                    dispatcher.forward(request, response);
	           
	                    response.sendRedirect("orders.jsp");
	                } else {
	                    out.println("order failed");
	                }
	            } else {
	                response.sendRedirect("login.jsp");
	            }

	        } catch (ClassNotFoundException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
