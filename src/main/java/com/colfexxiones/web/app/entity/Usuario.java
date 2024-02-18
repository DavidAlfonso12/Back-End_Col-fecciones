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

    @Column(nullable = false)
    private int usuario_documento;

    private String usuario_empresa;
    private String usuario_foto;
    private int usuario_ventas;
    private int usuario_compras;

    @ManyToOne
    @JoinColumn(name = "idEstado",nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

}
