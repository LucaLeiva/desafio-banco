package com.banco.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Long precio;

    private LocalDateTime fechaDeCreacion;

    public ProductoDTO(String nombre, Long precio, LocalDateTime fechaDeCreacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaDeCreacion = fechaDeCreacion;
    }
}
