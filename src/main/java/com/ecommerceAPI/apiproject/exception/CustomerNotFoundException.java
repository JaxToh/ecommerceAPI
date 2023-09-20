package com.ecommerceAPI.apiproject.exception;

public class CustomerNotFoundException extends RuntimeException{
  public CustomerNotFoundException(Long id) {
    super("Could not find customer " + id);
  }

}
