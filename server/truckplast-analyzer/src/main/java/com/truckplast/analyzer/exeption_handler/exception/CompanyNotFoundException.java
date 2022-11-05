package com.truckplast.analyzer.exeption_handler.exception;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
