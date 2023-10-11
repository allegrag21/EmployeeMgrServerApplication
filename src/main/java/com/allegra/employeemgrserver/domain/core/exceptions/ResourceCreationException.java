package com.allegra.employeemgrserver.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceCreationException extends Throwable {
    public ResourceCreationException(String s) {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}

