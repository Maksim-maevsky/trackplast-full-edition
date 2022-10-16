package com.truckplast.analyzer.exeption_handler.exception;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException() {
    }

    public RoleNotFoundException(String message) {
        super(message);
    }
}
