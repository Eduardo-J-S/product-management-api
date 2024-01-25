package br.com.api.products.exceptions;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.api.products.exceptions.validator.ExceptionValidator;

@Constraint(validatedBy = ExceptionValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalExceptionHandler {
    String message() default "The string must have at least 3 letters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
