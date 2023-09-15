package com.ecommerceAPI.apiproject.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerceAPI.apiproject.entity.Product;
import com.ecommerceAPI.apiproject.exceptions.ProductNotFoundException;


@RestController/*annotation tells the Java compiler that the class is a RESTful controller. This means that the class will be responsible for handling HTTP requests and returning responses.*/
@RequestMapping("/product")/*annotation to map HTTP requests to handler methods in Spring MVC controllers. */

public class ProductController {    /*annotation- RESTful endpoint that can be accessed using the GET HTTP method. The value of the annotation is the URI of the endpoint. */

private List<Product> allProduct;
//define @PostConstruct to load all the product data...only once
@PostConstruct
public void loadProduct(){

    allProduct = new ArrayList<>();

    allProduct.add(new Product("iPhone 14", "smartphones", "An apple mobile which is nothing like apple", 1299.10));
    allProduct.add(new Product("iPhone 15", "smartphones", "An apple mobile A16 Bionic powers all kinds of advanced features.", 1499.10));
    allProduct.add(new Product("iPhone 15 pro", "smartphones", "An apple mobile only for the professionals ", 1699.10));
}

//define endpoint for /allproducts - return a list of all products
    @GetMapping("/product")
public List<Product> getProduct(){
    return allProduct;
}

//define endpoint for /product/{productId} - return a product with id
@GetMapping("/product/{productId}")
public Product getProduct(@PathVariable int productId){
    //just index into the list

    //check the product id against list size
    if((productId>=allProduct.size())||(productId<0)){
        throw new ProductNotFoundException("Product id not found"+productId);
    }
    return allProduct.get(productId);
}


    }

