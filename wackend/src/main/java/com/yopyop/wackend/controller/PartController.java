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
import com.yopyop.wackend.dto.PartDTO;
import com.yopyop.wackend.dto.TagDTO;

@RestController
public class PartController {
	
    Logger logger = LoggerFactory.getLogger("PartController");
    /*
	@Autowired
	PartService partService;
	
    @RequestMapping(value="/part/{name}", method = RequestMethod.GET) 
    public ResponseEntity<PartDTO> getById(@PathVariable Integer id) throws Exception {
    	return new ResponseEntity<PartDTO>(partService.findById(id),HttpStatus.OK);
    }
    
    @RequestMapping(value="/part", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public List<PartDTO> getAll() throws Exception {
    	return partService.findAll();
    }
    
    @RequestMapping(value="/part", method = RequestMethod.POST) 
    @ResponseStatus(HttpStatus.OK)
    public PartDTO add(@RequestBody PartDTO erl) throws Exception {
    	return partService.add(erl);
    }
    
    @RequestMapping(value="/part/{id}", method = RequestMethod.DELETE) 
    public ResponseEntity<PartDTO> deleteById(@PathVariable Integer id) throws Exception {
    	partService.deleteById(id);
    	return new ResponseEntity<PartDTO>((PartDTO)null,HttpStatus.OK);
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);
    }*/
}