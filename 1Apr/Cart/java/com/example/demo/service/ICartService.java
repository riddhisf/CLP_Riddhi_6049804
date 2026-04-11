package com.example.demo.service;

import com.example.demo.model.Cart;

public interface ICartService {
	 public Cart addToCart(int pid);
	 public Cart getCart(int cartId);
}
