package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.repository.ImagenRepository;
import com.colfexxiones.web.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenService {

    @Autowired
    ImagenRepository  imagenRepository;

    @Autowired
    ProductoRepository productoRepository;

    public List<Imagen> getImagenes(){
        return imagenRepository.findAll();
    }

    public List<Imagen> getImagenByIdProducto(Long idImagen){
        return imagenRepository.findByIdProducto(idImagen);
    }

    public void saveOrUpdate(Imagen imagen){
        imagenRepository.save(imagen);
    }

    public void delete(Long idImagen){
        imagenRepository.deleteById(idImagen);
    }

    public void deleteByIdProducto(Long idProducto){
        List<Imagen> imagenes = imagenRepository.findByIdProducto(idProducto);

        for(Imagen imagen : imagenes){
            imagenRepository.delete(imagen);
        }
    }
}
