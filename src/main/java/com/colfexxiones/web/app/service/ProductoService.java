package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.repository.ImagenRepository;
import com.colfexxiones.web.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ImagenService imagenService;


    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> getProducto(Long idProducto){
        return productoRepository.findById(idProducto);
    }

    public void saveOrUpdate(Producto producto){
        productoRepository.save(producto);
    }

    public void delete(Long idProducto){
        productoRepository.deleteById(idProducto);
    }
}
