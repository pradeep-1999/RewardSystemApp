package com.example.telusDemo.exceptionHandling;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {

        super(message);
    }
}