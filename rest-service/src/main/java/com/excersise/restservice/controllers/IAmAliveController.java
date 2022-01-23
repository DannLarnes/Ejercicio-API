package com.excersise.restservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IAmAliveController {

    private static final Logger logger = LoggerFactory.getLogger(IAmAliveController.class);

    @GetMapping("/healthCheck")
    public ResponseEntity serviceHealthCheck(){
        logger.info("Se verifica que el servicio de controllers fue iniciado");
        return ResponseEntity.ok().build();
    }
}
