package com.ecommerceAPI.apiproject.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
    super("Could not find order " + id);
  }
}
