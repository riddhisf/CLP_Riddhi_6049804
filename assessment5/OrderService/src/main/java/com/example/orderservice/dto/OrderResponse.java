package com.example.orderservice.dto;

public class OrderResponse {

    private Integer orderId;
    private String userName;
    private String productName;
    private Integer quantity;
    private Double totalPrice;
    
	public OrderResponse(Integer orderId, String userName, String productName, Integer quantity, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}