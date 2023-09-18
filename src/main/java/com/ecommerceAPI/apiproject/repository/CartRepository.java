package com.ecommerceAPI.apiproject.repository;

import com.ecommerceAPI.apiproject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteById(Long id);
}
