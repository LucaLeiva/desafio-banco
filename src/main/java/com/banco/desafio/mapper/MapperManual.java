package com.banco.desafio.mapper;

import com.banco.desafio.dto.CrearProducto;
import com.banco.desafio.dto.ProductoDTO;
import com.banco.desafio.entities.ProductoEntity;

import java.time.LocalDateTime;

public class MapperManual {
    /*
    Crear Producto -> producto DTO <-> producto Entity

    o sea no puedo volver a transformarlo en crear producto
     */

    public static ProductoDTO crearProductoToProductoDTO(CrearProducto crearProducto) {
        ProductoDTO productoDTO = new ProductoDTO(
                crearProducto.getNombre(),
                crearProducto.getPrecio(),
                LocalDateTime.now()
        );

        return productoDTO;
    }

    public static ProductoDTO productoEntityToProductoDTO(ProductoEntity productoEntity) {
        ProductoDTO productoDTO = new ProductoDTO(
                productoEntity.getId(),
                productoEntity.getNombre(),
                productoEntity.getPrecio(),
                productoEntity.getFechaDeCreacion()
        );

        return productoDTO;
    }

    public static ProductoEntity productoDTOToProductoEntity(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = new ProductoEntity(
                productoDTO.getId(),
                productoDTO.getNombre(),
                productoDTO.getPrecio(),
                productoDTO.getFechaDeCreacion()
        );

        return productoEntity;
    }
}
