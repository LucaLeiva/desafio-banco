package com.banco.desafio.service;

import com.banco.desafio.dto.CrearProducto;
import com.banco.desafio.dto.ProductoDTO;
import com.banco.desafio.entities.ProductoEntity;
import com.banco.desafio.exception.ErrorNoEncontrado;
import com.banco.desafio.mapper.MapperManual;
import com.banco.desafio.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {
    @Autowired
    private final ProductoRepository repository;

    public List<ProductoDTO> getAllProducts() {
        List<ProductoEntity> lista = repository.findAll();
        List<ProductoDTO> listaNueva = new ArrayList<ProductoDTO>();
        for(int i = 0; i < lista.size(); i++) {
            listaNueva.add(MapperManual.productoEntityToProductoDTO(lista.get(i)));
        }

        return listaNueva;
    }

    public ProductoDTO getOneProductById(Integer id) {
        return MapperManual.productoEntityToProductoDTO(
                repository.findById(id)
                        .orElseThrow(() -> new ErrorNoEncontrado(id)));
    }

    public ProductoEntity createNewProduct(CrearProducto crearProducto) {
        ProductoDTO producto = MapperManual.crearProductoToProductoDTO(crearProducto);
        return repository.save(MapperManual.productoDTOToProductoEntity(producto));
    }

    public void deleteProductById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ErrorNoEncontrado(id);
        }
    }
}
