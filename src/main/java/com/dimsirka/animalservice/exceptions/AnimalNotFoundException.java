package com.dimsirka.animalservice.exceptions;

public class AnimalNotFoundException  extends RuntimeException{

    public AnimalNotFoundException(String message) {
        super(message);
    }

    public AnimalNotFoundException() {
    }
}
