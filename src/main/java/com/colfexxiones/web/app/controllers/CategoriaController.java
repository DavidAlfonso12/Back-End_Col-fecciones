package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.entity.Categoria;
import com.colfexxiones.web.app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping
    public List<Categoria> getAll(){
        return categoriaService.getCategorias();
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/{idCategoria}")
    public Optional<Categoria> getById(@PathVariable("idCategoria") Long idCategoria){
        return categoriaService.getCategoria(idCategoria);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping
    public Categoria saveUpdate(@RequestBody Categoria categoria){
        categoriaService.saveOrUpdate(categoria);
        return categoria;
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping("/{idCategoria}")
    public void delete(@PathVariable("idCategoria") Long idCategoria){
        categoriaService.delete(idCategoria);
    }
}
