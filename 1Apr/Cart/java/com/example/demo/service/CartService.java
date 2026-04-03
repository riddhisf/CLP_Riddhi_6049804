package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CartDTO;
import com.example.demo.exception.CartNotFoundException;
import com.example.demo.exception.ItemOutOfStockException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Catalog;
import com.example.demo.repostiory.ICartRepo;

@Service
public class CartService {
    @Autowired
    private ICartRepo repo;

    private RestTemplate rt = new RestTemplate();

    public Cart addToCart(int pid) {
        Cart cart = new Cart();
        Catalog product;
        try {
            product = rt.getForObject("http://localhost:8084/catalogs/products/" + pid, Catalog.class);
        } 
        catch (Exception e) {
            throw new ProductNotFoundException("Product Not Found.");
        }
        
        if (product.getItemsLeft() <= 0) {
            throw new ItemOutOfStockException("Item out of stock.");
        }

        cart.getProductIds().add(pid);
        return repo.save(cart);
    }

    public CartDTO getCart(int cartId) {
        Optional<Cart> op = repo.findById(cartId);
        Cart cart;
        if (op.isPresent()) {
            cart = op.get();
        } 
        else {
            throw new CartNotFoundException("Cart not found.");
        }

        List<Integer> pids = cart.getProductIds();
        Map<Integer, Catalog> products = new HashMap<>();

        for (Integer pid : pids) {
            Catalog product = rt.getForObject("http://localhost:8084/catalogs/products/" + pid,Catalog.class);
            if (product != null) {
                products.put(pid, product);
            }
        }

        List<Catalog> recommendations = rt.postForObject("http://localhost:8085/recommendations",pids,List.class);

        CartDTO dto = new CartDTO();
        dto.setCartId(cart.getCartId());
        dto.setProducts(products);
        dto.setRecommendations(recommendations);
        return dto;
    }
}