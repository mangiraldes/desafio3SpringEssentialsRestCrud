package com.giraldes.curso.devsuperior.serviceRest.DTO;
import com.giraldes.curso.devsuperior.serviceRest.controllers.handlers.CustomError;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldError> errors = new ArrayList<>();

    public void addError(String field,String message){
        errors.add(new FieldError(field,message));

    }
    public ValidationError(Instant errortime, int codigoErro, String description, String pathExcecution) {
        super(errortime, codigoErro, description, pathExcecution);
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}
