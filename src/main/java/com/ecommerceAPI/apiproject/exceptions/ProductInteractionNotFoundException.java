package com.ecommerceAPI.apiproject.exceptions;


//--------------This is an Exception type to handle and catch any errors-------------//
/*exception type is a class that represents a possible error that can occur in a program. 
Exceptions are used to handle unexpected events and to prevent the program from crashing. */

public class ProductInteractionNotFoundException extends RuntimeException{
  
    
    // public ProductNotFoundException(Long id) {
    // super("Could not find product " + id);}


//constructors


      public ProductInteractionNotFoundException(String message, Throwable cause) {
    super(message,cause);}

    public ProductInteractionNotFoundException(Long id) {
      super("Could not find product with ID: " + id);
  }







  }

