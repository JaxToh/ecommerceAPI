package com.ecommerceAPI.apiproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceAPI.apiproject.entity.Order;
import com.ecommerceAPI.apiproject.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}