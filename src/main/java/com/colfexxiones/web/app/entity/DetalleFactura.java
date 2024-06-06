package com.colfexxiones.web.app.entity;

import com.colfexxiones.web.app.DTO.ProductoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_detalle_factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad_comprado")
    private int cantidadComprado;

    @Column(name = "valor_compra_unitaria")
    private int valorUnidadCompra;

    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

}
