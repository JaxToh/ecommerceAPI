package com.ecommerceAPI.apiproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ecommerceAPI.apiproject.entity.ProductInteraction;
import com.ecommerceAPI.apiproject.exceptions.ProductInteractionNotFoundException;


@Service

public class ProductInteractionServiceImpl implements ProductInteractionService {
    
  @Autowired
  private ProductInteractionRepository productinteractionRepository;

  @Override
  public ProductInteraction saveInteraction(ProductInteraction productinteraction) {
    return productinteractionRepository.save(productinteraction);
  }

  @Override
  public ProductInteraction getInteraction(Long id) {
    return productinteractionRepository.findById(id).orElseThrow(() -> new ProductInteractionNotFoundException(id));
  }

  @Override
  public List<ProductInteraction> getAllInteractions() {
    return productinteractionRepository.findAll();
  }

  @Override
  public ProductInteraction updateInteraction(Long id, ProductInteraction productinteraction) {
    // Load the interaction
    ProductInteraction interactionToUpdate = productinteractionRepository.findById(id)
        .orElseThrow(() -> new ProductInteractionNotFoundException(id));
    interactionToUpdate.setRemarks(productinteraction.getRemarks());
    interactionToUpdate.setInteractionDate(productinteraction.getInteractionDate());
    return productinteractionRepository.save(interactionToUpdate);
  }

  @Override
  public void deleteInteraction(Long id) {
    productinteractionRepository.deleteById(id);
  }

    
}
