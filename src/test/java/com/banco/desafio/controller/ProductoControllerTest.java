package com.banco.desafio.controller;

import com.banco.desafio.dto.CrearProducto;
import com.banco.desafio.dto.ProductoDTO;
import com.banco.desafio.entities.ProductoEntity;
import com.banco.desafio.exception.ErrorNoEncontrado;
import com.banco.desafio.mapper.MapperManual;
import com.banco.desafio.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ProductoControllerTest {
    public static final Logger log = LoggerFactory.getLogger(ProductoControllerTest.class);

    @MockBean
    private ProductoService productoService;
    private ProductoController productoController;

    @BeforeEach
    void setUp() {
        productoController = new ProductoController(productoService);
    }

    @Test
    void whenFindAllProductsThenOk() {
        ProductoDTO productoDTO1 = Mockito.mock(ProductoDTO.class);
        ProductoDTO productoDTO2 = Mockito.mock(ProductoDTO.class);
        ProductoDTO productoDTO3 = Mockito.mock(ProductoDTO.class);

        List<ProductoDTO> listMock = Arrays.asList(productoDTO1, productoDTO2, productoDTO3);

        when(productoService.getAllProducts()).thenReturn(listMock);

        ResponseEntity<List<ProductoDTO>> expected = ResponseEntity.status(HttpStatus.OK).body(listMock);

        assertEquals(expected, productoController.findAllProducts());
    }

    @Test
    void whenFindOneProductByIdThenOk() {
        ProductoDTO productoDTO = Mockito.mock(ProductoDTO.class);

        when(productoService.getOneProductById(Mockito.any(Integer.class))).thenReturn(productoDTO);

        ResponseEntity<ProductoDTO> expected = ResponseEntity.status(HttpStatus.OK).body(productoDTO);

        assertEquals(expected, productoController.findOneProductById(1));
    }

    @Test
    void whenFindOneProductByIdThenFail() {
        ProductoDTO productoDTO = Mockito.mock(ProductoDTO.class);

        when(productoService.getOneProductById(Mockito.any(Integer.class))).thenThrow(new ErrorNoEncontrado(Mockito.any(Integer.class)));

        assertThrows(
                ErrorNoEncontrado.class,
                () -> {
                    productoController.findOneProductById(1);
                }
        );
    }

    @Test
    void whenCreateNewProductThenOk() {
        CrearProducto crearProducto = Mockito.mock(CrearProducto.class);
        ProductoDTO productoDTO = MapperManual.crearProductoToProductoDTO(crearProducto);
        ProductoEntity productoEntity = MapperManual.productoDTOToProductoEntity(productoDTO);

        when(productoService.createNewProduct(crearProducto)).thenReturn(productoEntity);

        ResponseEntity<ProductoEntity> expected = ResponseEntity.status(HttpStatus.CREATED).body(productoEntity);

        assertEquals(expected, productoController.createNewProduct(crearProducto));
    }

    @Test
    void whenDeleteOneProductByIdThenOk() {
        ResponseEntity<?> expected = ResponseEntity.status(HttpStatus.OK).build();

        assertEquals(expected, productoController.deleteProductById(1));
    }

    @Test
    void whenDeleteOneProductByIdThenFail() {
        // ?
    }
}