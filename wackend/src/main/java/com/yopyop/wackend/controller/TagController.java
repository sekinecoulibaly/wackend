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
import com.yopyop.wackend.dto.TagDTO;

@RestController
public class TagController {
	
    Logger logger = LoggerFactory.getLogger("TagController");
    
	@Autowired
	TagService tagService;
	
    @RequestMapping(value="/tag/{name}", method = RequestMethod.GET) 
    public ResponseEntity<TagDTO> getById(@PathVariable String name) throws Exception {
    	return new ResponseEntity<TagDTO>(tagService.findByName(name),HttpStatus.OK);
    }
    
    @RequestMapping(value="/tag", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public List<TagDTO> getAll() throws Exception {
    	return tagService.findAll();
    }
    
    @RequestMapping(value="/tag", method = RequestMethod.POST) 
    @ResponseStatus(HttpStatus.OK)
    public TagDTO add(@RequestBody TagDTO tag) throws Exception {
    	return tagService.add(tag);
    }

    /* Allow for dots in the name */
    @RequestMapping(value="/tag/{name:.+}", method = RequestMethod.DELETE) 
    public ResponseEntity<TagDTO> deleteByName(@PathVariable String name) throws Exception {
    	tagService.deleteByName(name);
    	return new ResponseEntity<TagDTO>((TagDTO)null,HttpStatus.OK);
    }
    
    @ExceptionHandler(GreetingException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);
    }
}