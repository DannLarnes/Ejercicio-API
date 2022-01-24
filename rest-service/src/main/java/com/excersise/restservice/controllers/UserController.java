package com.excersise.restservice.controllers;

import com.excersise.restservice.UserService.UserService;
import com.excersise.restservice.UserService.UsuarioStatusRes;
import com.excersise.restservice.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity login( @RequestBody Usuario usuario){
        logger.info("Validando usuario: " + usuario);
        if(userService.validateUser(usuario)) {
            logger.info("Usuario valido");
            return ResponseEntity.ok(new UsuarioStatusRes("Usuario valido"));
        }else{
            logger.error("Usuario o contraseña invalidos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new UsuarioStatusRes("Usuario o contraseña invalidos"));
        }
    }

}
