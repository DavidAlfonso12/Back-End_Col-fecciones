package com.colfexxiones.web.app.DTO;

import com.colfexxiones.web.app.entity.Categoria;
import com.colfexxiones.web.app.entity.Estado;
import com.colfexxiones.web.app.entity.Imagen;
import com.colfexxiones.web.app.entity.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public class ProductoDTO {

    private Long idProducto;
    private String producto_nombre;
    private String producto_descripcion;
    private double producto_precio;
    private LocalDateTime fecha_registro;
    private int cantidad_disponible;
    private int cantidad_vendidos;
    private Usuario usuario;
    private Categoria categoria;
    private Estado estado;

    private List<Imagen> imagenes;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_descripcion() {
        return producto_descripcion;
    }

    public void setProducto_descripcion(String producto_descripcion) {
        this.producto_descripcion = producto_descripcion;
    }

    public double getProducto_precio() {
        return producto_precio;
    }

    public void setProducto_precio(double producto_precio) {
        this.producto_precio = producto_precio;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getCantidad_vendidos() {
        return cantidad_vendidos;
    }

    public void setCantidad_vendidos(int cantidad_vendidos) {
        this.cantidad_vendidos = cantidad_vendidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
}
