package com.example.orderservice.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public OrderResponse createOrder(OrderRequest request) {

        User user = fetchUser(request.getUserId());
        Product product = fetchProduct(request.getProductId());

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

    @CircuitBreaker(name = "orderServiceCB", fallbackMethod = "userFallback")
    public User fetchUser(Integer userId) {
        return restTemplate.getForObject(
                "http://USERSERVICE/users/" + userId,
                User.class
        );
    }

    @CircuitBreaker(name = "orderServiceCB", fallbackMethod = "productFallback")
    public Product fetchProduct(Integer productId) {
        return restTemplate.getForObject(
                "http://PRODUCTSERVICE/products/" + productId,
                Product.class
        );
    }

    public User userFallback(Integer userId, Exception ex) {
        throw new RuntimeException("User Service Unavailable");
    }

    public Product productFallback(Integer productId, Exception ex) {
        throw new RuntimeException("Product Service Unavailable");
    }
}