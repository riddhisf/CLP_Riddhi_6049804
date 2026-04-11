package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;

public interface IOrderService {
	public OrderResponse createOrder(OrderRequest request);
}
