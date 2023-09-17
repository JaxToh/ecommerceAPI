package com.ecommerceAPI.apiproject.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.entity.ProductInteraction;
import com.ecommerceAPI.apiproject.service.ProductService;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/product")/*annotation to map HTTP requests to handler methods in Spring MVC controllers. */
@AllArgsConstructor

public class ProductController {

// private List<Product> allProduct;
// //define @PostConstruct to load all the product data...only once
// @PostConstruct
// public void loadProduct(){
//     allProduct = new ArrayList<>();
//     allProduct.add(new Product("iPhone 14", "smartphones", "An apple mobile which is nothing like apple", null, 1299.10));
//     allProduct.add(new Product("iPhone 15", "smartphones", "An apple mobile A16 Bionic powers all kinds of advanced features.", null, 1499.10));
//     allProduct.add(new Product("iPhone 15 pro", "smartphones", "An apple mobile only for the professionals ", null, 1699.10));
// }
  private ProductService productService;


  // CREATE
  @PostMapping("")
  public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
    return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
  }

  // READ (GET ALL)
  @GetMapping("")
  public ResponseEntity<List<Product>> getAllProduct() {
    return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
  }

  // READ (GET ONE)
  @GetMapping("{id}")
  public ResponseEntity<Product> getProduct(@PathVariable Long id) {
    return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
  }

  // UPDATE
  @PutMapping("{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);

  }

  // DELETE
  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Product>> searchProduct(@RequestParam String firstName) {
    return new ResponseEntity<>(productService.searchProducts(firstName), HttpStatus.OK);
  }

  // NESTED ROUTE
  @PostMapping("{id}/interactions")
  public ResponseEntity<ProductInteraction> addInteractionToProduct(@PathVariable Long id,
      @Valid @RequestBody ProductInteraction interaction) {
    return new ResponseEntity<>(productService.addInteractionToProduct(id, interaction), HttpStatus.CREATED);
  }



// //Define endpoint for /allproducts - return a list of all products
//     @GetMapping("/product")
// public List<Product> getProduct(){
//     return allProduct;
// }

// //Define endpoint for /product/{productId} - return a product with id
// @GetMapping("/product/{productId}")
// public Product getProduct(@PathVariable int productId){
// //check the product id against list size
// if((productId>=allProduct.size())||(productId<0)){
//    throw new ProductNotFoundException("Product id not found" + productId);
// }
// return allProduct.get(productId);
// }



    }




