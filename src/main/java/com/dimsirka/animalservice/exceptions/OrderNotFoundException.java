package com.dimsirka.animalservice.exceptions;

public class OrderNotFoundException extends  RuntimeException{
    public OrderNotFoundException(String message) {
        super(message);
    }
}
