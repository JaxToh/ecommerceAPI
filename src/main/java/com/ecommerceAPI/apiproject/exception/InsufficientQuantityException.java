package com.ecommerceAPI.apiproject.exception;

public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String message) {
        super("Insufficient quantity");
    }
}
