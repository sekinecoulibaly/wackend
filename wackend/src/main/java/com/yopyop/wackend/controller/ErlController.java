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

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yopyop.wackend.service.*;
import com.yopyop.wackend.controller.GreetingException;
import com.yopyop.wackend.dto.ErlDTO;
import com.yopyop.wackend.dto.SubscriptionDTO;

@RestController
public class ErlController {
	
    Logger logger = LoggerFactory.getLogger("ErlController");
    
	@Autowired
	ErlService erlService;
	
    @RequestMapping(value="/erl/{cid}", method = RequestMethod.GET) 
    public ResponseEntity<ErlDTO> getById(@PathVariable String cid) throws Exception {
    	return new ResponseEntity<ErlDTO>(erlService.findByCid(cid),HttpStatus.OK);
    }
    
    @RequestMapping(value="/erl", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public List<ErlDTO> getAll() throws Exception {
    	return erlService.findAll();
    }
    
    @RequestMapping(value="/erl", method = RequestMethod.POST) 
    @ResponseStatus(HttpStatus.OK)
    public ErlDTO add(@RequestBody ErlDTO erl) throws Exception {
    	return erlService.add(erl);
    }
    
    @RequestMapping(value="/erl/{cid}", method = RequestMethod.DELETE) 
    public ResponseEntity<ErlDTO> deleteByCid(@PathVariable String cid) throws Exception {
    	erlService.deleteByCid(cid);
    	return new ResponseEntity<ErlDTO>((ErlDTO)null,HttpStatus.OK);
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);
    }
}