package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Rol;
import com.colfexxiones.web.app.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAll(){
        return rolService.getRoles();
    }

    @GetMapping("/{idRol}")
    public Optional<Rol> getById(@PathVariable("idRol") Long idRol){
        return rolService.getRol(idRol);
    }

    @PostMapping
    public Rol saveUpdate(@RequestBody Rol rol){
        rolService.saveOrUpdate(rol);
        return rol;
    }

    @DeleteMapping("/{idRol}")
    public void delete(@PathVariable("idRol") Long idRol){
        rolService.delete(idRol);
    }


}
