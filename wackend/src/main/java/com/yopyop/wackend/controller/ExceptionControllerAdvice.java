package com.yopyop.wackend.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.yopyop.wackend.controller.ErrorResponse;
import com.yopyop.wackend.service.NotFoundException;

 
@ControllerAdvice
public class ExceptionControllerAdvice {
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		if (ex.getClass()==NotFoundException.class) {
			error.setMessage("ExceptionControllerAdvice() Not found");
			error.setErrorCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
		}
		else {
			error.setMessage("ExceptionControllerAdvice() " + ex.getClass() + "(" + ex.getMessage() + ")");
			error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({NoHandlerFoundException.class})
    ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex,
    		WebRequest request) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("ExceptionControllerAdvice() " + ex.getClass() + "(" + ex.getMessage() + ")");

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
