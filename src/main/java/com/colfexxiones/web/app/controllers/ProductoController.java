package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.service.ImagenService;
import com.colfexxiones.web.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ImagenService imagenService;

    @GetMapping
    public List<Producto> getAll(){
        return productoService.getProductos();
    }

    @GetMapping("/{idProducto}")
    public Optional<Producto> getById(@PathVariable("idProducto")Long idProducto){
        return productoService.getProducto(idProducto);
    }

    @PostMapping
    public Producto saveUpdate(@RequestBody Producto producto){
        productoService.saveOrUpdate(producto);
        return producto;
    }

    @DeleteMapping("/{idProducto}")
    public void delete(@PathVariable("idProducto")Long idProducto){
        imagenService.deleteByIdProducto(idProducto);
        productoService.delete(idProducto);
    }
}
