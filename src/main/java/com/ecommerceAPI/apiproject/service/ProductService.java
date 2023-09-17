package com.ecommerceAPI.apiproject.service;

import java.util.List;
import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.entity.ProductInteraction;

public interface ProductService {

    Product createProduct(Product product);

    Product getProduct(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    ProductInteraction addInteractionToProduct(Long id, ProductInteraction productInteraction);

    List<Product> searchProducts(String productName); // Corrected method name
    
}
