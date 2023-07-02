package com.aixel.recipeme.core.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException() {
        super();
    }

    public ValidationException(final String message) {
        super(message);
    }
}
