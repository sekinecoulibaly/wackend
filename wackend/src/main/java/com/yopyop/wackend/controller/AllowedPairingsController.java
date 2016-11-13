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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yopyop.wackend.service.*;
import com.yopyop.wackend.controller.GreetingException;
import com.yopyop.wackend.dto.AllowedPairingsDTO;

@RestController
public class AllowedPairingsController {
	
    Logger logger = LoggerFactory.getLogger("AllowedPairingsController");
    
	@Autowired
	AllowedPairingsService allowedPairingsService;
	
    @RequestMapping(value="/allowed_pairings/{erl_cid}", method = RequestMethod.GET) 
    public ResponseEntity<AllowedPairingsDTO> getByCid(@PathVariable String cid) throws Exception {
    	return new ResponseEntity<AllowedPairingsDTO>(allowedPairingsService.findByErlCid(cid),HttpStatus.OK);
    }
    
    @RequestMapping(value="/allowed_pairings", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public List<AllowedPairingsDTO> getAll() throws Exception {
    	return allowedPairingsService.findAll();
    }
    
    @RequestMapping(value="/allowed_pairings", method = RequestMethod.POST) 
    @ResponseStatus(HttpStatus.OK)
    public AllowedPairingsDTO add(@RequestBody AllowedPairingsDTO allowed_pairing) throws Exception {
    	return allowedPairingsService.add(allowed_pairing);
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);
    }
}