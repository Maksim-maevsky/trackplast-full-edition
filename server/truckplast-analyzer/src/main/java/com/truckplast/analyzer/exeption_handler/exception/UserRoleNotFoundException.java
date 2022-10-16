package com.truckplast.analyzer.exeption_handler.exception;

public class UserRoleNotFoundException extends RuntimeException{
    public UserRoleNotFoundException() {
    }

    public UserRoleNotFoundException(String message) {
        super(message);
    }
}
