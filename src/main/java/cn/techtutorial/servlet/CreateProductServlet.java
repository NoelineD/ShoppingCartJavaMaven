package cn.techtutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import cn.techtutorial.connection.dbConnect;
import cn.techtutorial.dao.ProductDao;
import cn.techtutorial.model.Product;


public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		On récupère les données du formulaire soumises par l'utilisateur à partir de la request
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String priceStr = request.getParameter("price"); // Récupérez la chaîne de prix
		String image = request.getParameter("image");
		
		double price = 0.0; // Valeur par défaut si la chaîne priceStr est nulle
		
		 if (priceStr != null && !priceStr.isEmpty()) {
		        // Si priceStr n'est ni nulle ni vide, convertissez-la en double
		        price = Double.parseDouble(priceStr);
		    }
		
//		create new product
		Product newProduct = new Product();
		newProduct.setName(name);
		newProduct.setCategory(category);
		newProduct.setPrice(price);
		newProduct.setImage(image);
		
		ProductDao productDao;
		try {
			productDao = new ProductDao(dbConnect.getConnection());
			boolean success = productDao.createNewProduct(newProduct);

			if (success) {
			    // Le produit a été créé avec succès, vous pouvez rediriger l'utilisateur vers une page de confirmation ou une autre page appropriée.
			    response.sendRedirect("confirmation.jsp");
			} else {
			    // Il y a eu une erreur lors de la création du produit, vous pouvez rediriger l'utilisateur vers une page d'erreur.
			    response.sendRedirect("error.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} // Remplacez dbConnect.getConnection() par votre méthode de connexion à la base de données

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
