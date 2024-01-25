package br.com.api.products.exceptions.validator;

import br.com.api.products.exceptions.GlobalExceptionHandler;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExceptionValidator implements ConstraintValidator<GlobalExceptionHandler, String> {

    private String message;

    @Override
    public void initialize(GlobalExceptionHandler annotation) {
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() > 3;
    }

    public String getMessage() {
        return message;
    }
}