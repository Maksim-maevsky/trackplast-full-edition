package com.truckplast.analyzer.exeption_handler.exception;

public class NoSuchCompanyException extends RuntimeException {
    public NoSuchCompanyException() {
    }

    public NoSuchCompanyException(String message) {
        super(message);
    }
}
