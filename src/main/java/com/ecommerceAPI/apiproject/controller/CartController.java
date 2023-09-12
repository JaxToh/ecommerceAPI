package com.ecommerceAPI.apiproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    @GetMapping("")
    public String getAllCarts() {
        return "all carts";
    }

}
