package com.giraldes.curso.devsuperior.serviceRest.services.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String message) {
        super(message);
    }
}
