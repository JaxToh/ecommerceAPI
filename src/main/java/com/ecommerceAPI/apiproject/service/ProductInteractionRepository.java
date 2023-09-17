package com.ecommerceAPI.apiproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceAPI.apiproject.entity.ProductInteraction;

public interface ProductInteractionRepository extends JpaRepository<ProductInteraction, Long> {


}
