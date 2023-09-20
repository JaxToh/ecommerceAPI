package com.ecommerceAPI.apiproject.service;

import java.util.List;
import com.ecommerceAPI.apiproject.entity.Product;

public interface ProductService {

    Product createProduct(Product product);

    Product getProduct(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> searchProducts(String productName); // Corrected method name
    
}