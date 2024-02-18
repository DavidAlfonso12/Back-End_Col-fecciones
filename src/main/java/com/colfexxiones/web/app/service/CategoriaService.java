package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Categoria;
import com.colfexxiones.web.app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoria(Long idCategoria){
        return categoriaRepository.findById(idCategoria);
    }

    public void saveOrUpdate(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public void delete(Long idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }
}
