package com.yopyop.wackend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Default controller that exists to return a proper REST response for unmapped requests.
 */
@RestController
public class DefaultController {

    @RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request) throws NoHandlerFoundException {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        HttpHeaders h = new HttpHeaders();

        throw new NoHandlerFoundException(method, uri, h);
    }
}