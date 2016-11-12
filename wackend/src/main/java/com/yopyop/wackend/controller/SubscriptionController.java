package com.yopyop.wackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yopyop.wackend.service.*;
import com.yopyop.wackend.controller.GreetingException;
import com.yopyop.wackend.dto.SubscriptionDTO;

@RestController
public class SubscriptionController {
	
    Logger logger = LoggerFactory.getLogger("SubscriptionController");
    
	@Autowired
	ErlService erlService;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	AllowedPairingsService allowedPairingsService;
	
    @RequestMapping(value="/subscription/{id}", method = RequestMethod.GET) 
    public ResponseEntity<SubscriptionDTO> getById(@PathVariable Integer id) throws Exception {
    	return new ResponseEntity<SubscriptionDTO>(subscriptionService.findById(id),HttpStatus.OK);
    }
    
    @RequestMapping(value="/subscription", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public List<SubscriptionDTO> getAll() throws Exception {
    	return subscriptionService.findAll();
    }
    
    @RequestMapping(value="/subscription", method = RequestMethod.POST) 
    @ResponseStatus(HttpStatus.OK)
    public SubscriptionDTO add(SubscriptionDTO subscription) throws Exception {
    	return subscriptionService.add(subscription);
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);
    }
}