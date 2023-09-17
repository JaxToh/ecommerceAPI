package com.ecommerceAPI.apiproject.service;

import java.util.List;

import com.ecommerceAPI.apiproject.entity.ProductInteraction;

public interface ProductInteractionService {

    public ProductInteraction saveInteraction(ProductInteraction productInteration);
  
    public ProductInteraction getInteraction(Long id);
  
    public List<ProductInteraction> getAllInteractions();
  
    public ProductInteraction updateInteraction(Long id, ProductInteraction productInteration);
  
    public void deleteInteraction(Long id);
    
}
