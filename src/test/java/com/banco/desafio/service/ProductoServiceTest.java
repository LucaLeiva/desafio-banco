package com.banco.desafio.service;

import com.banco.desafio.dto.CrearProducto;
import com.banco.desafio.dto.ProductoDTO;
import com.banco.desafio.entities.ProductoEntity;
import com.banco.desafio.exception.ErrorNoEncontrado;
import com.banco.desafio.mapper.MapperManual;
import com.banco.desafio.repository.ProductoRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ProductoServiceTest {
    public static final Logger log = LoggerFactory.getLogger(ProductoServiceTest.class);

    @MockBean
    private ProductoRepository productoRepository;
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        productoService = new ProductoService(productoRepository);
    }

    @Test
    void whenGetAllProductsThenOk() {
        ProductoEntity productoEntity1 = Mockito.mock(ProductoEntity.class);
        ProductoEntity productoEntity2 = Mockito.mock(ProductoEntity.class);
        ProductoEntity productoEntity3 = Mockito.mock(ProductoEntity.class);

        List<ProductoEntity> listMock = Arrays.asList(productoEntity1, productoEntity2, productoEntity3);

        when(productoRepository.findAll()).thenReturn(listMock);

        assertTrue(productoService.getAllProducts().get(0) instanceof ProductoDTO);
    }

    @Test
    void whenFindOneProductByIdThenOk() {
        ProductoEntity productoEntity = Mockito.mock(ProductoEntity.class);
        ProductoDTO productoDTO = MapperManual.productoEntityToProductoDTO(productoEntity);

        when(productoRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(productoEntity));

        assertTrue(productoService.getOneProductById(1) instanceof ProductoDTO);
    }

    @Test
    void whenFindOneProductByIdThenFail() {
        ProductoDTO productoDTO = Mockito.mock(ProductoDTO.class);

        when(productoRepository.findById(Mockito.any(Integer.class))).thenThrow(new ErrorNoEncontrado(Mockito.any(Integer.class)));

        assertThrows(
                ErrorNoEncontrado.class,
                () -> {
                    productoService.getOneProductById(1);
                }
        );
    }

    @Test
    void whenCreateNewProductThenOk() {
        CrearProducto crearProducto = Mockito.mock(CrearProducto.class);
        ProductoDTO productoDTO = MapperManual.crearProductoToProductoDTO(crearProducto);
        ProductoEntity productoEntity = MapperManual.productoDTOToProductoEntity(productoDTO);

        when(productoRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);

        assertTrue(productoService.createNewProduct(crearProducto) instanceof ProductoEntity);
    }

    @Test
    void whenDeleteOneProductByIdThenOk() {
        // ?
    }

    @Test
    void whenDeleteOneProductByIdThenFail() {
        when(productoRepository.existsById(Mockito.any(Integer.class))).thenThrow(ErrorNoEncontrado.class);

        assertThrows(
                ErrorNoEncontrado.class,
                () -> {
                    productoService.deleteProductById(1);
                }

        );
    }
}