package com.giraldes.curso.devsuperior.serviceRest.controllers.handlers;

import java.time.Instant;

public class CustomError {

    private Instant errortime;
    private int codigoErro;
    private String description;
    private String pathExcecution;

    public CustomError(Instant errortime, int codigoErro, String description, String pathExcecution) {
        this.errortime = errortime;
        this.codigoErro = codigoErro;
        this.description = description;
        this.pathExcecution = pathExcecution;
    }

    public Instant getErrortime() {
        return errortime;
    }

    public int getCodigoErro() {
        return codigoErro;
    }

    public String getDescription() {
        return description;
    }

    public String getPathExcecution() {
        return pathExcecution;
    }
}
