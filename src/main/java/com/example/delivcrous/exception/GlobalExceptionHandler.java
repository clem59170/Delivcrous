package com.example.delivcrous.exception;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.ConstraintViolationException;

import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            // Vérifier si la violation concerne le mot de passe
            if ("password".equals(propertyPath)) {
                // Ajouter des informations supplémentaires
                sb.append("Password violation: ").append(message).append(" ");
            } else {
                sb.append(propertyPath).append(": ").append(message).append(" ");
            }
        }
        // Écrire dans la console
        System.out.println("Constraint Violations: " + sb.toString());

        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }

    // Ajoutez d'autres méthodes @ExceptionHandler ici pour gérer d'autres types d'exceptions
}
