package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.CalificacionProducto;
import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.repository.CalificacionProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionProductoService {

    @Autowired
    CalificacionProductoRepository calificacionProductoRepository;

    public List<CalificacionProducto> getCalificacionProducto(Long idProducto){
        return calificacionProductoRepository.findByProducto(idProducto);
    }

    public List<CalificacionProducto> getCalificacionesUsuario(Long idUsuario){
        return calificacionProductoRepository.findByUsuario(idUsuario);
    }

    public void saveOrUpdate(CalificacionProducto calificacionProducto){
        calificacionProductoRepository.save(calificacionProducto);
    }
}
