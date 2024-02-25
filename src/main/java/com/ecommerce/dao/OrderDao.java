package com.ecommerce.dao;

import java.util.*;

import com.ecommerce.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
;

public class OrderDao {
	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public OrderDao(Connection con) {
    	this.con = con;
    }
    
    public boolean insertOrder(Order model) {
    	
    	boolean result = false;
    	
    	try {
    		
    		query= "insert into orders (product_id, user_id, quantity, date) values (?,?,?,?)";
    		pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUserId());
            pst.setInt(3, model.getQuantity());
            pst.setString(4, model.getDate());
            pst.executeUpdate();
            result = true; 

    		
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return result;
    }
    
    public List<Order> userOrders(int id){
    	List<Order> list = new ArrayList<>();
    	try {
    		query = "select * from orders where user_id=? order by orders.order_id desc";
    		pst = this.con.prepareStatement(query);
    		pst.setInt(1, id);
    		rs = pst.executeQuery();
    		
    	while (rs.next()) {
    		Order order= new Order();
    		ProductDao productDao = new ProductDao(this.con);
    		int productId = rs.getInt("product_id");
    		
    		Product product = productDao.getSingleProduct(productId);
    		order.setOrderId(rs.getInt("order_id"));
    		order.setId(productId);
    		order.setName(product.getName());
    		order.setCategory(product.getCategory());
    		order.setPrice(product.getPrice()*rs.getInt("quantity"));
    	    order.setQuantity(rs.getInt("quantity"));
    	    order.setDate(rs.getString("date"));
    	    list.add(order);
    	}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    public void cancelOrder (int id) {
    	try {
            query = "delete from orders where order_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate(); // Use executeUpdate() for delete requests
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        try {
            query = "SELECT * FROM orders ORDER BY orders.order_id DESC";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                ProductDao productDao = new ProductDao(this.con);
                int productId = rs.getInt("product_id");

                Product product = productDao.getSingleProduct(productId);
                order.setOrderId(rs.getInt("order_id"));
                order.setId(productId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice() * rs.getInt("quantity"));
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("date"));
                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    }

