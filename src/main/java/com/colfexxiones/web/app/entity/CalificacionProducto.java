package com.colfexxiones.web.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name = "calificacion_producto")
public class CalificacionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int calificacion;
    private String comentario;
    private Date fecha;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    
}
