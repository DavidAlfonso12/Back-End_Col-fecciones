package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Estado;
import com.colfexxiones.web.app.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAll(){
        return estadoService.getEstados();
    }

    @GetMapping("/{idEstado}")
    public Optional<Estado> getById(@PathVariable("idEstado") Long idEstado){
        return estadoService.getEstado(idEstado);
    }

    @PostMapping
    public Estado saveUpdate(@RequestBody Estado estado){
        estadoService.saveOrUpdate(estado);
        return estado;
    }

    @DeleteMapping("/{idEstado}")
    public void delete(@PathVariable("idEstado") Long idEstado){
        estadoService.delete(idEstado);
    }
}
