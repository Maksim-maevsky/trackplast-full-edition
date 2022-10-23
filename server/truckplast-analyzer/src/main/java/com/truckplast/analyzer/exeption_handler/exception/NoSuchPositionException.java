package com.truckplast.analyzer.exeption_handler.exception;

public class NoSuchPositionException extends RuntimeException{

    public NoSuchPositionException() {
    }

    public NoSuchPositionException(String message) {
        super(message);
    }
}
