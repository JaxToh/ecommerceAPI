package com.ecommerceAPI.apiproject.service;


import java.util.List;

import com.ecommerceAPI.apiproject.entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);
    Cart updateCart(Long id, Cart cart);
    void deleteCart(Long id);
    Cart getCartById(Long id);
    List<Cart> getAllCart();
    
}
