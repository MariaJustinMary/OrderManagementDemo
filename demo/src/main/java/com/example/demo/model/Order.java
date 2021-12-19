package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class Order {
    
	@Id
    private String orderID;
    private String orderStatus;
    private int quantity;
    private String itemID;
    
    public void Order(String orderID, String orderStatus, int quantity, String itemID) {
        super();
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.itemID = itemID;
    }

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

}
