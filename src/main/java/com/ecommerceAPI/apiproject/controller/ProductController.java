package com.ecommerceAPI.apiproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*annotation tells the Java compiler that the class is a RESTful controller. 
This means that the class will be responsible for handling HTTP requests and returning responses.
*/
@RequestMapping("/products")
/*annotation is used in Java to map HTTP requests to handler methods in Spring MVC controllers. */

public class ProductController {
    @GetMapping("")
    /*annotation tells the Java compiler that the method is a RESTful endpoint that can be accessed using the GET HTTP method. 
The value of the annotation is the URI of the endpoint. */
    public String getAllProducts() {
        return "all products";
    }
    
}
