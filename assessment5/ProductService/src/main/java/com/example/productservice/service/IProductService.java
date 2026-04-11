package com.example.productservice.service;

import java.util.List;

import com.example.productservice.model.Product;

public interface IProductService {
    Product createProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
}
