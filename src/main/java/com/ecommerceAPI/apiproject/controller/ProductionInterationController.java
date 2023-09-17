package com.ecommerceAPI.apiproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerceAPI.apiproject.entity.ProductInteraction;
import com.ecommerceAPI.apiproject.service.ProductInteractionService;

public class ProductionInterationController {
    
  private ProductInteractionService interactionService;

  // Create
  @PostMapping("")
  public ResponseEntity<ProductInteraction> createInteraction(@RequestBody ProductInteraction interaction) {
    ProductInteraction newInteraction = interactionService.saveInteraction(interaction);
    return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);
  }

  // Read All
  @GetMapping("")
  public ResponseEntity<List<ProductInteraction>> getAllInteractions() {
    List<ProductInteraction> allInteractions = interactionService.getAllInteractions();
    return new ResponseEntity<>(allInteractions, HttpStatus.OK);
  }

  // Read One
  @GetMapping("{id}")
  public ResponseEntity<ProductInteraction> getInteraction(@PathVariable Long id) {
    ProductInteraction foundInteraction = interactionService.getInteraction(id);
    return new ResponseEntity<>(foundInteraction, HttpStatus.OK);

  }

  // Update
  @PutMapping("{id}")
  public ResponseEntity<ProductInteraction> updateInteraction(@PathVariable Long id, ProductInteraction interaction) {
    ProductInteraction updatedInteraction = interactionService.updateInteraction(id, interaction);
    return new ResponseEntity<>(updatedInteraction, HttpStatus.OK);

  }

  // Delete
  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> deleteInteraction(@PathVariable Long id) {
    interactionService.deleteInteraction(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
