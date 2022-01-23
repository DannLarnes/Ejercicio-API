package com.excersise.restservice.UserService;

public class UsuarioStatusRes {
    private String status;

    public UsuarioStatusRes(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
