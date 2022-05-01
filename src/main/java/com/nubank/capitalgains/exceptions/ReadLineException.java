package com.nubank.capitalgains.exceptions;

public class ReadLineException extends RuntimeException {

    public ReadLineException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
