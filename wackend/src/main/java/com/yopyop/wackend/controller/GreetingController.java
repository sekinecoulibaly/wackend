package com.yopyop.wackend.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yopyop.wackend.model.Greeting;
import com.yopyop.wackend.service.GreetingService;
import com.yopyop.wackend.service.NotFoundException;
import com.yopyop.wackend.controller.GreetingException;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    Logger logger = LoggerFactory.getLogger("GreetingController");
    
	@Autowired
	GreetingService greetingService;
    	
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return null;
    }
    
    @RequestMapping(value = "/greeting/{id}/{content}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Greeting> setById(@PathVariable Integer id, @PathVariable String content) throws GreetingException {
    	if (content.length()<5) {
    		throw new GreetingException("Content too short");
		}
    	try {
    		Greeting greeting = greetingService.findById(id);
    		return new ResponseEntity<Greeting>(greeting,HttpStatus.OK);
    	}
    	catch (NotFoundException e) {
    		throw new GreetingException("Not found");
		}
	}

    
    @RequestMapping(value = "/greeting/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Greeting> getById(@PathVariable Integer id) throws GreetingException {
    	try {
    		Greeting greeting = greetingService.findById(id);
    		return new ResponseEntity<Greeting>(greeting,HttpStatus.OK);
		} catch (NotFoundException e) {
			throw new GreetingException("Not found");
		}
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);

    }

    
}