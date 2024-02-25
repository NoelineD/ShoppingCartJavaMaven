package com.ecommerce.servlet;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import com.ecommerce.model.Cart;
import com.ecommerce.servlet.AddToCartServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AddToCartServletTest {

    @Test
    public void testDoGet() throws ServletException, IOException {
        AddToCartServlet servlet = new AddToCartServlet();
        
        // Créer une liste de panier simulée
        ArrayList<Cart> cartList = new ArrayList<>();
        
        // Créer des objets simulés HttpServletRequest, HttpServletResponse et HttpSession
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpSession session = new MockHttpSession();
        
        // Définir les paramètres nécessaires dans la requête simulée
        request.setParameter("id", "1");
        
        // Définir la session dans la requête
        request.setSession(session);
        
        // Appeler la méthode doGet du servlet avec la requête et la réponse simulées
        servlet.doGet(request, response);
        
        // Vérifier si l'article est ajouté au panier
        assertTrue(cartList.size() == 1);
        
        // Vérifier la réponse
        assertEquals("item already exist in cart", response.getContentAsString());
        
        // Vérifier la quantité de l'article ajouté
        Cart cartItem = cartList.get(0);
        assertEquals(1, cartItem.getQuantity());
    }
}