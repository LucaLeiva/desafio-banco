package com.banco.desafio.exception;

public class ErrorNoEncontrado extends RuntimeException{
    private String type;
    // private String mensaje;
    // no me deja llamar al mensaje en el constructor, asi que creo que no tiene sentido que tenga un atributo mensaje

    public ErrorNoEncontrado(Integer id) {
        // lo hago asi porque en teoria las API Rest siempre tendrian que recibir y devolver JSONs :P,
        // en teoria devolviendolo como String es lo mismo
        super("{'Error': 'El producto(id=" + id + ") no existe'}");
    }
}
