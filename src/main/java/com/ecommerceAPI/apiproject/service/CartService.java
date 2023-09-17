package com.ecommerceAPI.apiproject.service;


import com.ecommerceAPI.apiproject.entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);

    void deleteCart(Long cartId);

    Cart getCartById(Long cartId);
}
