package com.example.orderservice.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.Product;
import com.example.orderservice.dto.User;
import com.example.orderservice.exception.InsufficientStockException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "orderServiceCB", fallbackMethod = "orderFallback")
    public OrderResponse createOrder(OrderRequest request) {

        User user = restTemplate.getForObject(
                "http://USERSERVICE/users/" + request.getUserId(),
                User.class
        );

        Product product = restTemplate.getForObject(
                "http://PRODUCTSERVICE/products/" + request.getProductId(),
                Product.class
        );

        if (request.getQuantity() > product.getQuantity()) {
            throw new InsufficientStockException(
                    "Requested quantity exceeds available stock. Available: "
                    + product.getQuantity()
            );
        }

        Double total = product.getPrice() * request.getQuantity();

        return new OrderResponse(
                new Random().nextInt(10000),
                user.getName(),
                product.getName(),
                request.getQuantity(),
                total
        );
    }

    public OrderResponse orderFallback(OrderRequest request, Exception ex) {
    	if (ex instanceof HttpClientErrorException) {
            throw (HttpClientErrorException) ex;
        }
    	else if(ex instanceof InsufficientStockException) {
    		throw (InsufficientStockException) ex;
    	}
    	
        return new OrderResponse(
                -1,
                "Unknown",
                "Unknown",
                request.getQuantity(),
                0.0
        );
    }
}
