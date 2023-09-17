package com.ecommerceAPI.apiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceAPI.apiproject.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
