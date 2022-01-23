package com.excersise.restservice.controllers;

import com.excersise.restservice.consumeRest.response.Coordenadas;
import com.excersise.restservice.consumeRest.service.ProvinciasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CoordenadasController {
    private static final Logger logger = LoggerFactory.getLogger(CoordenadasController.class);

    @Autowired
    private ProvinciasService provinciasService;

    @GetMapping("/coordenadas")
    public Coordenadas obtenerCoordenadasProvincia(@RequestParam("provincia") String nombreProvincia){
        logger.info("Buscando coordenadas de provincia"+nombreProvincia);
        if(nombreProvincia==null || nombreProvincia.isEmpty()){
            logger.error("Parametro nombre vacio");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede buscar una provincia sin su nombre");
        }
        Coordenadas res=provinciasService.getCoordenadasProvincia(nombreProvincia);
        logger.info("Coordenadas encontradas");
        return res;
    }

}
