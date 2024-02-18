package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.repository.UploadFileRepository;
import com.colfexxiones.web.app.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/imagenes")
public class ImagenController {

    @Autowired
    ImagenService imagenService;

    @Autowired
    UploadFileRepository uploadFileRepository;

    @GetMapping
    public List<Imagen> getAll(){
        return imagenService.getImagenes();
    }

    @GetMapping("/{idImagen}")
    public List<Imagen> getById(@PathVariable("idImagen") Long idImagen){
        return imagenService.getImagenByIdProducto(idImagen);
    }

    @PostMapping
    public Imagen saveUpdate(@RequestBody Imagen imagen){
        imagenService.saveOrUpdate(imagen);
        return imagen;
    }

    @DeleteMapping("/{idImagen}")
    public void delete(@PathVariable("idImagen")Long idImagen){
        imagenService.delete(idImagen);
    }

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file, Long idProducto) throws Exception {
        return new ResponseEntity<>(uploadFileRepository.handleFileUpload(file,idProducto), HttpStatus.OK);
    }
}
