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
import com.ecommerceAPI.apiproject.service.ProductService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/products")

public class ProductController {

  private ProductService productService;

  // CREATE
  @PostMapping("")
  public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
    return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
  }

  // READ (GET ALL)
  @GetMapping("")
  public ResponseEntity<List<Product>> getAllProducts() {
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


    }