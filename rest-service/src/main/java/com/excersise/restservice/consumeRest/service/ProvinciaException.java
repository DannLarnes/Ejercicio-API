package com.excersise.restservice.consumeRest.service;

public class ProvinciaException extends RuntimeException{
    public ProvinciaException() {
        super();
    }

    public ProvinciaException(String message) {
        super(message);
    }

    public ProvinciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProvinciaException(Throwable cause) {
        super(cause);
    }
}
