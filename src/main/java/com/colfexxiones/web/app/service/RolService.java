package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Rol;
import com.colfexxiones.web.app.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public List<Rol> getRoles(){
        return rolRepository.findAll();
    }

    public Optional<Rol> getRol(Long id){
        return rolRepository.findById(id);
    }

    public void saveOrUpdate(Rol rol){
        rolRepository.save(rol);
    }

    public void delete(Long id){
        rolRepository.deleteById(id);
    }
}
