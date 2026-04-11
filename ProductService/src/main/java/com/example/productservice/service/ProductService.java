package com.example.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.repository.IProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
    private IProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> op = productRepository.findById(id);
        if(op.isPresent()) {
        	Product product = op.get();
        	return product;
        }
        else {
        	throw new ProductNotFoundException("ProductNotFound");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
