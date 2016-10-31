package com.yopyop.wackend.controller;

public class GreetingException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public GreetingException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public GreetingException() {
        super();
    }
}
