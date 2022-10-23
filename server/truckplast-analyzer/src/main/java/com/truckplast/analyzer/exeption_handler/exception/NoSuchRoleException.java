package com.truckplast.analyzer.exeption_handler.exception;

public class NoSuchRoleException extends RuntimeException{

    public NoSuchRoleException() {
    }

    public NoSuchRoleException(String message) {
        super(message);
    }
}
