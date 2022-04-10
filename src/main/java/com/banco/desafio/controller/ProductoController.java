package com.banco.desafio.controller;

import com.banco.desafio.dto.CrearProducto;
import com.banco.desafio.dto.ProductoDTO;
import com.banco.desafio.entities.ProductoEntity;
import com.banco.desafio.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    private final ProductoService service;

    @GetMapping(value = "/productos")
    ResponseEntity<List<ProductoDTO>> findAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());
    }

    @GetMapping(value = "/productos/{idProducto}")
    ResponseEntity<ProductoDTO> findOneProductById(@PathVariable Integer idProducto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getOneProductById(idProducto));
    }

    @PostMapping(value = "/productos")
    ResponseEntity<ProductoEntity> createNewProduct (@RequestBody CrearProducto nuevoProducto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewProduct(nuevoProducto));
    }

    @DeleteMapping(value = "/productos/{idProducto}")
    ResponseEntity<?> deleteProductById(@PathVariable Integer idProducto) {
        service.deleteProductById(idProducto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
