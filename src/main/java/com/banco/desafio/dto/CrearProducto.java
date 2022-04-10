package com.banco.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearProducto {

    private String nombre;

    private String descripcion;

    private Long precio;

    public CrearProducto(String nombre, Long precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
