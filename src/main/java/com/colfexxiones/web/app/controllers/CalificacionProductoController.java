package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.CalificacionProducto;
import com.colfexxiones.web.app.service.CalificacionProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path = "api/v1/calificaciones")
public class CalificacionProductoController {

    @Autowired
    CalificacionProductoService calificacionProductoService;


    @GetMapping("/{id}")
    public List<CalificacionProducto> getCalificacionesUsuario(@PathVariable("id") Long id){
        return calificacionProductoService.getCalificacionesUsuario(id);
    }

    @GetMapping("/producto/{id}")
    public List<CalificacionProducto> getCalificacionesProducto(@PathVariable("id") Long id){
        return calificacionProductoService.getCalificacionProducto(id);
    }
}
