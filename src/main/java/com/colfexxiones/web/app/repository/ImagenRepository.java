package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
    @Query("SELECT i FROM Imagen i WHERE i.producto.idProducto = :idProducto")
    List<Imagen> findByIdProducto(@Param("idProducto") Long producto);


}
