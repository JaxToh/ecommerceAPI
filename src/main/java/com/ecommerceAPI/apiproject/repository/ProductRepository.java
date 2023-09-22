package com.ecommerceAPI.apiproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceAPI.apiproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByName(String name);
}