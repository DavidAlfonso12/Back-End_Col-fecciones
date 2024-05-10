package com.colfexxiones.web.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String usuario_nombre;

    @Column(nullable = false)
    private String usuario_apellido;

    @Column(nullable = false)
    private String usuario_telefono;

    @Column(unique = true, nullable = false)
    private String usuario_email;

    @Column(nullable = false)
    private String usuario_password;

    private int usuario_documento;
    private String usuario_direccion;
    private String usuario_empresa;
    private String usuario_foto;
    private int usuario_ventas;
    private int usuario_compras;
    private String usuario_descripcion;

    @ManyToOne
    @JoinColumn(name = "idEstado",nullable = false)
    private Estado estado;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_telefono() {
        return usuario_telefono;
    }

    public void setUsuario_telefono(String usuario_telefono) {
        this.usuario_telefono = usuario_telefono;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getUsuario_password() {
        return usuario_password;
    }

    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }

    public int getUsuario_documento() {
        return usuario_documento;
    }

    public void setUsuario_documento(int usuario_documento) {
        this.usuario_documento = usuario_documento;
    }

    public String getUsuario_direccion() {
        return usuario_direccion;
    }

    public void setUsuario_direccion(String usuario_direccion) {
        this.usuario_direccion = usuario_direccion;
    }

    public String getUsuario_empresa() {
        return usuario_empresa;
    }

    public void setUsuario_empresa(String usuario_empresa) {
        this.usuario_empresa = usuario_empresa;
    }

    public String getUsuario_foto() {
        return usuario_foto;
    }

    public void setUsuario_foto(String usuario_foto) {
        this.usuario_foto = usuario_foto;
    }

    public int getUsuario_ventas() {
        return usuario_ventas;
    }

    public void setUsuario_ventas(int usuario_ventas) {
        this.usuario_ventas = usuario_ventas;
    }

    public int getUsuario_compras() {
        return usuario_compras;
    }

    public void setUsuario_compras(int usuario_compras) {
        this.usuario_compras = usuario_compras;
    }

    public String getUsuario_descripcion() {
        return usuario_descripcion;
    }

    public void setUsuario_descripcion(String usuario_descripcion) {
        this.usuario_descripcion = usuario_descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario() {
    }

    public Usuario(Long idUsuario, String usuario_nombre, String usuario_apellido, String usuario_telefono, String usuario_email, String usuario_password, Estado estado) {
        this.idUsuario = idUsuario;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_telefono = usuario_telefono;
        this.usuario_email = usuario_email;
        this.usuario_password = usuario_password;
        this.estado = estado;
    }

    public Usuario(Long idUsuario, String usuario_nombre, String usuario_apellido, String usuario_telefono, String usuario_email, String usuario_password, int usuario_documento, String usuario_direccion, String usuario_empresa, String usuario_foto, int usuario_ventas, int usuario_compras, String usuario_descripcion, Estado estado, Rol rol) {
        this.idUsuario = idUsuario;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_telefono = usuario_telefono;
        this.usuario_email = usuario_email;
        this.usuario_password = usuario_password;
        this.usuario_documento = usuario_documento;
        this.usuario_direccion = usuario_direccion;
        this.usuario_empresa = usuario_empresa;
        this.usuario_foto = usuario_foto;
        this.usuario_ventas = usuario_ventas;
        this.usuario_compras = usuario_compras;
        this.usuario_descripcion = usuario_descripcion;
        this.estado = estado;
        this.rol = rol;
    }

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

}
