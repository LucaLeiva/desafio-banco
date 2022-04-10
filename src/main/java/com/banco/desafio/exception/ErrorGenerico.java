package com.banco.desafio.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ErrorGenerico extends RuntimeException{
    private String type;
    // private String mensaje;
    // mismo problema que con ErrorNoEncontrado

    public ErrorGenerico() {
        super("{'Error': 'Se produjo un error desconocido'}");
    }
}
