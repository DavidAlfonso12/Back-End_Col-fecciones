package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/imagenes")
public class ImagenController {

    @Autowired
    ImagenService imagenService;

    @GetMapping
    public List<Imagen> getAll(){
        return imagenService.getImagenes();
    }

    @GetMapping("/{idImagen}")
    public List<Imagen> getById(@PathVariable("idImagen") Long idImagen){
        return imagenService.getImagenByIdProducto(idImagen);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping
    public Imagen saveUpdate(@RequestBody Imagen imagen){
        imagenService.saveOrUpdate(imagen);
        return imagen;
    }

    @DeleteMapping("/{idImagen}")
    public void delete(@PathVariable("idImagen")Long idImagen){
        imagenService.delete(idImagen);
    }


}
