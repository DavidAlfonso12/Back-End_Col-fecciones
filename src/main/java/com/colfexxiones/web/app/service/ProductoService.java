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

    public List<Producto> getProductosVendedor(Long idVendedor){
        return productoRepository.findByVendedor(idVendedor);
    }

    public Optional<Producto> restarCantidadProducto(Long idProducto, int cantidad){
        Optional<Producto> productoOpcional = productoRepository.findById(idProducto);
        if (productoOpcional.isPresent()){
            Producto producto = productoOpcional.get();
            if (producto.getCantidad_disponible() >= cantidad){
                producto.setCantidad_disponible(producto.getCantidad_disponible() - cantidad);
                productoRepository.save(producto);
                return Optional.of(producto);
            }else{
                throw new IllegalArgumentException("La cantidad a restar excede la cantidad disponible del producto.");
            }
        }else{
            return Optional.empty();
        }
    }

    public Optional<Producto> sumarCantidadVentaProducto(Long idProducto, int cantidad){
        Optional<Producto> productoOpcional = productoRepository.findById(idProducto);
        if (productoOpcional.isPresent()){
            Producto producto = productoOpcional.get();
            producto.setCantidad_vendidos(producto.getCantidad_vendidos() + cantidad);
            productoRepository.save(producto);
            return Optional.of(producto);
        }else{
            return Optional.empty();
        }
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
