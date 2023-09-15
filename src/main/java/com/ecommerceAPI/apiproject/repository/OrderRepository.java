package com.ecommerceAPI.apiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceAPI.apiproject.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
