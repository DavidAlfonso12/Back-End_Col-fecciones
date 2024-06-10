package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    @Query("SELECT factura FROM Factura factura WHERE factura.usuario.idUsuario = :idUsuario")
    List<Factura> findByUsuario(@Param("idUsuario") Long usuario);


}
