package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.CalificacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionProductoRepository extends JpaRepository<CalificacionProducto, Integer> {
    @Query("SELECT calificaciones FROM CalificacionProducto calificaciones WHERE calificaciones.producto.idProducto = :idProducto")
    List<CalificacionProducto> findByProducto(@Param("idProducto") Long producto);

    @Query("SELECT c FROM CalificacionProducto c WHERE c.usuario.idUsuario = :idUsuario")
    List<CalificacionProducto> findByUsuario(@Param("idUsuario") Long usuario);
}
