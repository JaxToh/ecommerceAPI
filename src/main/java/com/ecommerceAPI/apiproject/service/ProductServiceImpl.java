package com.ecommerceAPI.apiproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.exception.ProductNotFoundException;
import com.ecommerceAPI.apiproject.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  // Create
  @Override
  public Product createProduct(Product Product) {
    // return Product;
    return productRepository.save(Product);
  }

  // Get One
  @Override
  public Product getProduct(Long id) {

    return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
  }

  // Get All
  @Override
  public List<Product> getAllProducts() {
    List<Product> allProducts = productRepository.findAll();
    return allProducts;
  }

  // Update
  @Override
  public Product updateProduct(Long id, Product Product) {

    // Retrieve Product from DB
    Product ProductToUpdate = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

    // Update the fields
    ProductToUpdate.setName(Product.getName());
    ProductToUpdate.setShortDescription(Product.getShortDescription());
    ProductToUpdate.setLongDescription(Product.getLongDescription());
    ProductToUpdate.setPrice(Product.getPrice());
    //ProductToUpdate.setStock(Product.getStock());
    return productRepository.save(ProductToUpdate);
  }

  // Delete
  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<Product> searchProducts(String name) {
    List<Product> foundProducts = productRepository.findByName(name);
    return foundProducts;
  }

}