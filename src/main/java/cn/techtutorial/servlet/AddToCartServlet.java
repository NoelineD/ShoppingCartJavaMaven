package cn.techtutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cn.techtutorial.model.Cart;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text:html;charset=UTF-8");
//		try(PrintWriter out= response.getWriter()) {
//			ArrayList<Cart> cartList = new ArrayList<>();
//			int id = Integer.parseInt(request.getParameter("id"));
//			Cart cm = new Cart();
//			cm.setId(id);
//			cm.setQuantity(1);
//			
//			HttpSession session = request.getSession();
//			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//		
//		}
	}

	

}
