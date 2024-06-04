package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.CalificacionProducto;
import com.colfexxiones.web.app.repository.CalificacionProductoRepository;
import com.colfexxiones.web.app.repository.ProductoRepository;
import com.colfexxiones.web.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public CalificacionProducto saveOrUpdate(@RequestBody CalificacionProducto calificacionProducto){
        calificacionProductoRepository.save(calificacionProducto);
        return calificacionProducto;
    }
}
