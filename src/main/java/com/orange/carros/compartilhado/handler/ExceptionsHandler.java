package com.orange.carros.compartilhado.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handlerHibernateValidator(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String campo = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String mensagem = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        ExceptionResponse exceptionResponse = new ExceptionResponse(campo, mensagem, String.valueOf(HttpStatus.BAD_REQUEST));

        return ResponseEntity.status(400).body(exceptionResponse);
    }

}
