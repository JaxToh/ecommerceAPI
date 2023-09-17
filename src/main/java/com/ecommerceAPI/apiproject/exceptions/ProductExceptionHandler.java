package com.ecommerceAPI.apiproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ecommerceAPI.apiproject.errorresponse.ProductErrorResponse;

@ControllerAdvice
public class ProductExceptionHandler {
    //===============================EXCEPTION HANDLERS========================================//
// Exception handler->Type of response entity/body->Exception type to handle/catch
@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException exc) {


    // Create a ProductErrorResponse object
    ProductErrorResponse error = new ProductErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());



    // Return a ResponseEntity with the ProductErrorResponse object
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}

//Catch all
@ExceptionHandler
public ResponseEntity<ProductErrorResponse> handleException(Exception exc){

    // Create a ProductErrorResponse object
    ProductErrorResponse error = new ProductErrorResponse();
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());



    // Return a ResponseEntity with the ProductErrorResponse object
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
}
