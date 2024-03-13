package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getUsuarios();
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/{idUsuario}")
    public Optional<Usuario> getById(@PathVariable("idUsuario") Long idUsuario){
        return usuarioService.getUsuario(idUsuario);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/login")
    public Optional<Usuario> getByUserRegistered(@RequestParam("usuario_email")String email, @RequestParam("usuario_password")String password){
        return usuarioService.getUsuarioEmailPass(email,password);
    }
    
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/rol/{idRol}")
    public List<Usuario> getByRolUser(@PathVariable("idRol") Long idRol){
        return usuarioService.getUsuarioRol(idRol);
    }

    @CrossOrigin("http://127.0.0.1:5500")
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
