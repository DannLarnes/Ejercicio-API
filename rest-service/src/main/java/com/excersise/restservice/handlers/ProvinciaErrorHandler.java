package com.excersise.restservice.handlers;

import com.excersise.restservice.consumeRest.service.ProvinciaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProvinciaErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ProvinciaErrorHandler.class);

    @ResponseBody
    @ExceptionHandler(ProvinciaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String provinciaNotFoundHandler(ProvinciaException e ){
        logger.error(e.getMessage());
        return e.getMessage();
    }
}
