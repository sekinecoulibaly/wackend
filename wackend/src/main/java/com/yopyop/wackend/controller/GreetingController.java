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

import com.yopyop.wackend.model.*;
import com.yopyop.wackend.service.*;
import com.yopyop.wackend.controller.GreetingException;
import com.yopyop.wackend.dto.SubscriptionDTO;

@RestController
public class GreetingController {
	
    Logger logger = LoggerFactory.getLogger("GreetingController");
    
	@Autowired
	GreetingService greetingService;
    
	@Autowired
	ErlService erlService;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	AllowedPairingsService allowedPairingsService;
	
    @RequestMapping(value="/allowed", method = RequestMethod.GET) 
    public ResponseEntity<List<AllowedPairings>> toto() throws Exception {
    	logger.warn("/allowed");
    	
    	List<AllowedPairings> allowedPairings = allowedPairingsService.findAll();
    	//Erl erl = erlService.findByCid("C000000001");

    	return new ResponseEntity<List<AllowedPairings>>(allowedPairings,HttpStatus.OK);
    }
    
    @RequestMapping(value="/greeting", method = RequestMethod.GET) 
    public Greeting greeting() throws Exception {
    	logger.warn("id is empty");
    	throw new GreetingException("Invalid query");
    }
    
    @RequestMapping(value = "/greeting/{id}/{content}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Greeting> setById(@PathVariable Integer id, @PathVariable String content) throws Exception {
    	if (content.length()<5) {
    		throw new GreetingException("Content too short");
		}

		return new ResponseEntity<Greeting>(greetingService.findById(id),HttpStatus.OK);
	}

    @RequestMapping(value = "/greeting/{id}", method = RequestMethod.GET, produces = "application/json")
    public Greeting getById(@PathVariable Integer id) throws Exception {
    	return greetingService.findById(id);
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);
    }
}