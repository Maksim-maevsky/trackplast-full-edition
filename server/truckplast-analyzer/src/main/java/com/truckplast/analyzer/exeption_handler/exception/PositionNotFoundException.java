package com.truckplast.analyzer.exeption_handler.exception;

public class PositionNotFoundException extends RuntimeException{
    public PositionNotFoundException() {
    }

    public PositionNotFoundException(String message) {
        super(message);
    }
}
