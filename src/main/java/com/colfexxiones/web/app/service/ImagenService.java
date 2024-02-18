package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.repository.ImagenRepository;
import com.colfexxiones.web.app.repository.ProductoRepository;
import com.colfexxiones.web.app.repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ImagenService implements UploadFileRepository {

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


    @Override
    public String handleFileUpload(MultipartFile file, Long idProducto) throws Exception {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if(fileSize > maxFileSize){
                return "File size must be less than or equial 5MB";
            }

            if(!fileOriginalName.endsWith(".png") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".jpg"))
            {
                return "Only PNG, JPEG, JPG files are allowed! ";
            }

            String fileExtencion = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtencion;

            File folder = new File("src/main/resources/pictures");
            if(!folder.exists()){
                folder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/pictures/" + newFileName);
            Files.write(path, bytes);

            Imagen imagen = new Imagen();
            Producto producto = new Producto();

            imagen.setImagen_nombre(newFileName);
            producto = productoRepository.getById(idProducto);
            imagen.setProducto(producto);

            imagenRepository.save(imagen);

            return "File Upload seccesfully!";


        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
