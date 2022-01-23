package com.excersise.restservice.consumeRest.service;

import com.excersise.restservice.consumeRest.response.Coordenadas;
import com.excersise.restservice.consumeRest.response.ProvinciaRs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProvinciasServiceImpl implements ProvinciasService{

    private static final Logger logger = LoggerFactory.getLogger(ProvinciasServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provinciasService.url}")
    private String urlServicio;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Coordenadas getCoordenadasProvincia(String nombre) throws ProvinciaException {
        logger.info("Llamando al servicio "+urlServicio);
        ProvinciaRs res=restTemplate.getForObject(urlServicio+"?nombre={nombre}",ProvinciaRs.class,nombre);
        logger.info("Obtenida la respuesta : ");
        try {
            logger.info(mapper.writeValueAsString(res));
        }catch (JsonProcessingException e){
            logger.error("Problema con json mapper");
        }
        if(res.getCantidad()==0){
            logger.error("La cantidad de provincias recibidas del servicio: "+ urlServicio+" es 0" );
            throw new ProvinciaException("Provincia no encontrada");
        }
        return res.getProvincias().get(0).getCentroide();
    }
}
