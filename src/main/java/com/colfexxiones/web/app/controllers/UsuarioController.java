package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public Optional<Usuario> getById(@PathVariable("idUsuario") Long idUsuario){
        return usuarioService.getUsuario(idUsuario);
    }

    @PostMapping
    public Usuario saveUpdate(@RequestBody Usuario usuario){
        usuarioService.saveOrUpdate(usuario);
        return usuario;
    }

    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable("idUsuario") Long idUsuario){
        usuarioService.delete(idUsuario);
    }
}
