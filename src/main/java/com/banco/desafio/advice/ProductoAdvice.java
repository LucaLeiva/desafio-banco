package com.banco.desafio.advice;

import com.banco.desafio.exception.ErrorNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductoAdvice {
    @ResponseBody
    @ExceptionHandler(ErrorNoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String errorNoEncontrado(ErrorNoEncontrado ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String errorGenerico(Exception ex) {
        return ex.getMessage();
    }
}
