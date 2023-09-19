package com.ecommerceAPI.apiproject.exceptions;


public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String message) {
        super("Insufficient quantity");
    }
}
