package com.ecommerceAPI.apiproject.controller;

import com.ecommerceAPI.apiproject.entity.Cart;
import com.ecommerceAPI.apiproject.service.CartService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    // @Autowired
    // public CartController(CartService cartService) {
    //     this.cartService = cartService;
    // }

    // Create a new cart
    @PostMapping("")
    public ResponseEntity<Cart> createCart(@Valid @RequestBody Cart cart) {
        //Cart createdCart = cartService.createCart(cart);
        return new ResponseEntity<>(cartService.createCart(cart), HttpStatus.CREATED);
    }

    // Retrieve a cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        //Cart cart = cartService.getCartById(id);
        return new ResponseEntity<>(cartService.getCartById(id), HttpStatus.OK);
    }

    // Retrieve all carts
    @GetMapping("")
    public ResponseEntity<List<Cart>> getAllCarts() {
        //List<Cart> carts = cartService.getAllCart();
        return new ResponseEntity<>(cartService.getAllCart(), HttpStatus.OK);
    }

    // Update a cart by ID
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Cart updatedCart = cartService.updateCart(id, cart);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    // Delete a cart by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
