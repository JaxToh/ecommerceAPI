package com.ecommerceAPI.apiproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.entity.ProductInteraction;
import com.ecommerceAPI.apiproject.exceptions.ProductNotFoundException;
import com.ecommerceAPI.apiproject.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepository productRepository;
    private ProductInteractionRepository productInteractionRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductInteractionRepository productInteractionRepository) {
        this.productRepository = productRepository;
        this.productInteractionRepository = productInteractionRepository;
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
    ProductToUpdate.setProductName(Product.getProductName());
    ProductToUpdate.setProductCat(Product.getProductCat());
    ProductToUpdate.setProductDesc(Product.getProductDesc());
    ProductToUpdate.setProductStock(Product.getProductStock());
    ProductToUpdate.setProductPrice(Product.getProductPrice());
    return productRepository.save(ProductToUpdate);
  }


  // Delete
  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public ProductInteraction addInteractionToProduct(Long id, ProductInteraction productInteraction) {
      // Retrieve Product
      Product selectedProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

      // Add the ProductInteraction to the product
      productInteraction.setProduct(selectedProduct);
      return productInteractionRepository.save(productInteraction);
  }

    @Override
    public List<Product> searchProducts(String productName) {
        List<Product> foundProducts = productRepository.findByproductName(productName);
        return foundProducts;
    }

    
}
