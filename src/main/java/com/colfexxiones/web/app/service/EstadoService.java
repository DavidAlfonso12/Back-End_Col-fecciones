package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Estado;
import com.colfexxiones.web.app.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    public List<Estado> getEstados(){
        return estadoRepository.findAll();
    }

    public Optional<Estado> getEstado(Long id){
        return estadoRepository.findById(id);
    }

    public void saveOrUpdate(Estado estado){
        estadoRepository.save(estado);
    }

    public void delete(Long id){
        estadoRepository.deleteById(id);
    }
}
