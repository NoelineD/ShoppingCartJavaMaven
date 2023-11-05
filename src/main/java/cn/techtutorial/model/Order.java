package cn.techtutorial.model;

public class Order extends Product{
	private int order_id;
	private int user_id;
	private int quantity;
	private String date;
	
	public Order(int order_id, int user_id, int quantity, String date) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.quantity = quantity;
		this.date = date;
	}

	public Order() {
		
	}

	public int getOrderId() {
		return order_id;
	}

	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
} 
