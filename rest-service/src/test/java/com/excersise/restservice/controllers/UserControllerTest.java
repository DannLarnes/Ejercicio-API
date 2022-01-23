package com.excersise.restservice.controllers;

import com.excersise.restservice.UserService.UsuarioStatusRes;
import com.excersise.restservice.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void usuarioYPasswordValidos(){
        Usuario req = new Usuario("Matias","123Probando");
        ResponseEntity res=userController.login(req);
        Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
        UsuarioStatusRes resStatus = (UsuarioStatusRes)res.getBody();
        Assertions.assertTrue(resStatus.getStatus().equals("Usuario valido"));
    }

    @Test
    void usuarioValidoYPasswordInvalida(){
        Usuario req = new Usuario("Matias","asdasdasdasd");
        ResponseEntity res=userController.login(req);

        UsuarioStatusRes resStatus = (UsuarioStatusRes)res.getBody();
        String mensajeEsperado="Usuario o contraseña invalidos";
        String mensajeObtenido= resStatus.getStatus();
        Assertions.assertTrue(mensajeObtenido.equals(mensajeEsperado));
    }


    @Test
    void usuarioYPasswordInvalidos(){
        Usuario req = new Usuario("asdsdasdasdasd","asdasdasdasd");
        ResponseEntity res=userController.login(req);
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED,res.getStatusCode());
        UsuarioStatusRes resStatus = (UsuarioStatusRes)res.getBody();
        String mensajeEsperado="Usuario o contraseña invalidos";
        String mensajeObtenido= resStatus.getStatus();
        Assertions.assertTrue(mensajeObtenido.equals(mensajeEsperado));
    }

}
