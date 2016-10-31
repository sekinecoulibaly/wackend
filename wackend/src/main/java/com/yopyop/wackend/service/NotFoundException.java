package com.yopyop.wackend.service;

/**
 * This exception is thrown if the requested contact is not found.
 * @author Petri Kainulainen
 */
public class NotFoundException extends Exception {
    private static final long serialVersionUID = 2L;
    
    public NotFoundException(String message) {
        super(message);
    }
}