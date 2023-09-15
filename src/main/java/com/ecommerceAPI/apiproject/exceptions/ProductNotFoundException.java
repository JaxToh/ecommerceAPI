package com.ecommerceAPI.apiproject.exceptions;

public class ProductNotFoundException extends RuntimeException{
  
    
    public ProductNotFoundException(Long id) {
    super("Could not find product " + id);}


//constructors
      public ProductNotFoundException(String message) {
    super(message);
  }

      public ProductNotFoundException(String message, Throwable cause) {
    super(message,cause);}

      public ProductNotFoundException(Throwable cause) {
    super(cause);}






  }

