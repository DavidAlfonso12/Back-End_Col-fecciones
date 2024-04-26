package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.DTO.ProductoDTO;
import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.service.ImagenService;
import com.colfexxiones.web.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ImagenService imagenService;

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping
    public List<ProductoDTO> getAll(){
        List<Producto> productos = productoService.getProductos();
        List<ProductoDTO> productosDto = new ArrayList<>();
        for(Producto producto : productos) {
            productosDto.add(mapearProductoDto(producto));
        }
        return productosDto;
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/{idProducto}")
    public ProductoDTO getById(@PathVariable("idProducto")Long idProducto){
        Optional<Producto> producto = productoService.getProducto(idProducto);
        return mapearProductoDto(producto.orElse(new Producto()));
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/vendedor/{idVendedor}")
    public List<ProductoDTO> getByIdVendedor(@PathVariable("idVendedor")Long idVendedor){
        List<Producto> productos =  productoService.getProductosVendedor(idVendedor);
        List<ProductoDTO> productosDto = new ArrayList<>();
        for(Producto producto : productos) {
            productosDto.add(mapearProductoDto(producto));
        }
        return productosDto;
    }
    private ProductoDTO mapearProductoDto (Producto producto){
        List<Imagen> imagenes = imagenService.getImagenByIdProducto(producto.getIdProducto());
        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setCantidad_disponible(producto.getCantidad_disponible());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setCantidad_vendidos(producto.getCantidad_vendidos());
        productoDTO.setEstado(producto.getEstado());
        productoDTO.setProducto_descripcion(producto.getProducto_descripcion());
        productoDTO.setFecha_registro(producto.getFecha_registro());
        productoDTO.setProducto_nombre(producto.getProducto_nombre());
        productoDTO.setProducto_precio(producto.getProducto_precio());
        productoDTO.setImagenes(imagenes);
        productoDTO.setUsuario(producto.getUsuario());

        return productoDTO;
    }
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping
    public Producto saveUpdate(@RequestBody Producto producto){
        productoService.saveOrUpdate(producto);
        return producto;
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping("/{idProducto}")
    public void delete(@PathVariable("idProducto")Long idProducto){
        imagenService.deleteByIdProducto(idProducto);
        productoService.delete(idProducto);
    }
}
