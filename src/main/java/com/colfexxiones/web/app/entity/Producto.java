package com.colfexxiones.web.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false)
    private String producto_nombre;

    private String producto_descripcion;

    @Column(nullable = false)
    private double producto_precio;

    @Column(nullable = false)
    private LocalDateTime fecha_registro;

    @Column(nullable = false)
    private int cantidad_disponible;

    @Column(nullable = false)
    private int cantidad_vendidos;


    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idEstado", nullable = false)
    private Estado estado;
}
