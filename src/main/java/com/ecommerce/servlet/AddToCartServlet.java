package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ecommerce.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		response.setContentType("text:html;charset=UTF-8");
		//		HttpSession actualSession = (HttpSession) request.getAttribute("session"); ajouter pour le test

		try(PrintWriter out= response.getWriter()) {
			
//			Une nouvelle liste cartList est créée pour stocker des objets de type Cart. liste utilisée pour gérer le panier.
			ArrayList<Cart> cartList = new ArrayList<>();
			
//          Cette ligne récupère un paramètre nommé "id" de la requête GET et le convertit en un entier.
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
//			L'identifiant (id) de l'objet Cart est défini avec la valeur récupérée à partir du paramètre "id" de la requête.
			cm.setId(id);
//			quantité initialisé à 1
			cm.setQuantity(1);
			
//			Une session HTTP est récupérée à partir de la requête et donc les infos gardé de l'utilisateur
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//			(ArrayList<Cart>) : C'est le casting. Il indique au compilateur que vous transformez l'objet retourné par session.getAttribute("cart-list") en un objet du type qu'on veut 
		
			if(cart_list == null) {
			  cartList.add(cm);
			  session.setAttribute("cart-list",cartList);
			  response.sendRedirect("index.jsp");
			} else {
			  cartList = cart_list;
			  //est ce que le produit existe dans le panier sinon juste ajouter quantité
			  boolean exist = false;
			  
			  for(Cart c:cart_list) {
				  if(c.getId() == id) {
					  exist = true;
					  out.println("<h3 style='color: crimson; text-align: center;'>item already exist in cart <a href='cart.jsp'> go to cart page</a></h3>");
				  }
				  
			  }
			  
			  if(!exist) {
				  cartList.add(cm);
				  response.sendRedirect("index.jsp");
			  }
			}

			
		}
	}

	

}
