package br.com.api.products.exceptions;

public class FieldValidationException extends RuntimeException {

    public FieldValidationException(String message){
        super(message);
    }
}
