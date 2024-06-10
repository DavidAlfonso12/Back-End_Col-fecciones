package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.DetalleFactura;
import com.colfexxiones.web.app.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
    @Query("SELECT d FROM DetalleFactura d WHERE d.factura.id = :idFactura")
    List<DetalleFactura> findDetalleIdFactura(@Param("idFactura") Integer idFactura);

    @Query("SELECT v FROM DetalleFactura v WHERE v.producto.usuario.idUsuario = :idUsuario")
    List<DetalleFactura> findDetalleIdUsuario(@Param("idUsuario") Long idUsuario);

    @Query("SELECT f FROM DetalleFactura f WHERE f.factura.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<DetalleFactura> buscarPorFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT fv FROM DetalleFactura fv WHERE fv.producto.usuario.idUsuario = :idUsuario AND fv.factura.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<DetalleFactura> buscarPorFechaYUsuario(@Param("idUsuario")Long idUsuario, @Param("fechaInicio")Date fechaInicio,@Param("fechaFin") Date fechaFin);
}
