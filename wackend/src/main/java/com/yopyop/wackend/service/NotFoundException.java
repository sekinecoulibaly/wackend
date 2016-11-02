package com.yopyop.wackend.service;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * This exception is thrown if the requested contact is not found.
 * @author Petri Kainulainen
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="NotFoundException() This customer is not found in the system")
public class NotFoundException extends Exception {
    private static final long serialVersionUID = 2L;
    
    public NotFoundException(String message) {
        super(message);
    }
}