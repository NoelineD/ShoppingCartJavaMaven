package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import cn.techtutorial.model.*;

public class ProductDao {
	
	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public ProductDao(Connection con) {
		this.con = con;
	}	

public List<Product>getAllProducts(){
	List<Product> products = new ArrayList<Product>();
	
	try {
		query= "select * from products";
		pst= this.con.prepareStatement(query);
		rs= pst.executeQuery();
		
		while(rs.next()) {
			Product row = new Product();
			row.setId(rs.getInt("id"));
			row.setName(rs.getString("name"));
			row.setCategory(rs.getString("category"));
			row.setPrice(rs.getDouble("price"));
			row.setImage(rs.getString("image"));
			
			products.add(row);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return products;
}

public List<Cart> getCartProducts(ArrayList<Cart> cartList){
	List<Cart> products = new ArrayList<Cart>();
	
	try {
		if(cartList.size()>0) {
			for(Cart item:cartList) {
				query = "select * from products where id=?";
				pst= this.con.prepareStatement(query);
				pst.setInt(1,item.getId());
				rs = pst.executeQuery();
				while(rs.next()) {
					Cart row = new Cart();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setCategory(rs.getString("category"));
					row.setPrice(rs.getDouble("price")*item.getQuantity());
					row.setQuantity(item.getQuantity());
					products.add(row);
				}
			}
		}
		
	} catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
	return products;
}

public Product getSingleProduct(int id) {
	Product row = new Product();
	try {
		query= "select * from products where id=?";
		pst= this.con.prepareStatement(query);
		pst.setInt(1, id);
		rs=pst.executeQuery();
		
		while(rs.next()) {
			row.setId(rs.getInt("id"));
			row.setName(rs.getString("name"));
			row.setCategory(rs.getString("Category"));
			row.setPrice(rs.getDouble("price"));
			row.setImage(rs.getString("image"));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return row;
}

public double getTotalCartPrice(ArrayList<Cart> cartList) {
	double sum = 0;
	
	try {
		
		if(cartList.size()>0) {
			for(Cart item:cartList) {
				query= "select price from products where id=?";
				pst= this.con.prepareStatement(query);
				pst.setInt(1, item.getId());
				rs=pst.executeQuery();
				
				while(rs.next()) {
					sum+=rs.getDouble("price")*item.getQuantity();
				}
			}
		}
	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return sum;
}

public boolean createNewProduct(Product product) {
    try {
    	
        query = "INSERT INTO products (name, category, price, image) VALUES (?, ?, ?, ?)";
        pst = this.con.prepareStatement(query);
        pst.setString(1, product.getName());
        pst.setString(2, product.getCategory());
        pst.setDouble(3, product.getPrice());
        pst.setString(4, product.getImage());
        int rowsInserted = pst.executeUpdate();
        return rowsInserted > 0;
        
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

public boolean modifyProduct(Product product) {
    try {
        query = "UPDATE products SET name = ?, category = ?, price = ?, image = ? WHERE id = ?";
        pst = this.con.prepareStatement(query);
        pst.setString(1, product.getName());
        pst.setString(2, product.getCategory());
        pst.setDouble(3, product.getPrice());
        pst.setString(4, product.getImage());
        pst.setInt(5, product.getId());
        int rowsUpdated = pst.executeUpdate();
        return rowsUpdated > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}