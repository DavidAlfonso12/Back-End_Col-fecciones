package com.colfexxiones.web.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;
    private String estado_descripcion;


    public Estado() {
    }

    public Estado(Long idEstado, String estado_descripcion) {
        this.idEstado = idEstado;
        this.estado_descripcion = estado_descripcion;
    }
}
