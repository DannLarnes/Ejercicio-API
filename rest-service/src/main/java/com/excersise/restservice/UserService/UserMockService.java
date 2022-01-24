package com.excersise.restservice.UserService;

import com.excersise.restservice.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="mock")
public class UserMockService implements UserService{

    @Value("${validUser}")
    private String validUser;

    @Value("${validPassword}")
    private String validPassword;

    public Boolean validateUser(Usuario user){
        return (user.getNombre()!=null && user.getNombre().equals(validUser)) &&
                (user.getPassword()!=null && user.getPassword().equals(validPassword));
    }


}
