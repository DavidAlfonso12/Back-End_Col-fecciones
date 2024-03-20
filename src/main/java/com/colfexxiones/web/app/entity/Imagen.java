package com.colfexxiones.web.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String imagen_base64;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;


    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public String getImagen_base64() {
        return imagen_base64;
    }

    public void setImagen_base64(String imagen_base64) {
        this.imagen_base64 = imagen_base64;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
