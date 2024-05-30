package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
    @Query("SELECT d FROM DetalleFactura d WHERE d.factura.id = :idFactura")
    List<DetalleFactura> findDetalleIdFactura(@Param("idFactura") Integer idFactura);
}
