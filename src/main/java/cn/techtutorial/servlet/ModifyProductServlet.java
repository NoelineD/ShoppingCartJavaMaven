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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ModifyProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérez les données du formulaire soumises par l'utilisateur à partir de la request
        int productId = Integer.parseInt(request.getParameter("id"));

        ProductDao productDao;
        try {
            productDao = new ProductDao(dbConnect.getConnection());
            Product product = productDao.getSingleProduct(productId);

            // Placez le produit dans la portée de la requête
            request.setAttribute("product", product);

            // Redirigez vers la page JSP pour afficher le formulaire de modification
            request.getRequestDispatcher("modifyproduct.jsp").forward(request, response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Gérez les erreurs ici
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérez les erreurs ici
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérez les données du formulaire soumises par l'utilisateur à partir de la request
        int productId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String priceStr = request.getParameter("price");
        String image = request.getParameter("image");

        double price = 0.0;

        if (priceStr != null && !priceStr.isEmpty()) {
            price = Double.parseDouble(priceStr);
        }

        // Créez un objet Product avec les nouvelles valeurs
        Product modifiedProduct = new Product();
        modifiedProduct.setId(productId);
        modifiedProduct.setName(name);
        modifiedProduct.setCategory(category);
        modifiedProduct.setPrice(price);
        modifiedProduct.setImage(image);

        ProductDao productDao;
        try {
            productDao = new ProductDao(dbConnect.getConnection());
            boolean success = productDao.modifyProduct(modifiedProduct);

            if (success) {
                // La modification du produit a réussi, redirigez l'utilisateur vers une page de confirmation.
                response.sendRedirect("confirmation.jsp");
            } else {
                // Il y a eu une erreur lors de la modification du produit, redirigez l'utilisateur vers une page d'erreur.
                response.sendRedirect("error.jsp");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Gérez les erreurs ici
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérez les erreurs ici
        }
    }
}