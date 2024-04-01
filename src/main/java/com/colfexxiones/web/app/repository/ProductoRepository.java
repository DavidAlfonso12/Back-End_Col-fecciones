package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query ("SELECT productosVendedor FROM Producto productosVendedor WHERE productosVendedor.usuario.idUsuario = :idVendedor")
    List<Producto> findByVendedor(@Param("idVendedor")Long idVendedor);
}
