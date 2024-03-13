package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
   @Autowired
    UsuarioRepository usuarioRepository;

   public List<Usuario> getUsuarios() {
       return usuarioRepository.findAll();
   }

   public Optional<Usuario> getUsuario(Long idUsuario){
       return usuarioRepository.findById(idUsuario);
   }

   public void saveOrUpdate(Usuario usuario){
       usuarioRepository.save(usuario);
   }

   public void delete(Long idUsuario){
       usuarioRepository.deleteById(idUsuario);
   }

   public Optional<Usuario> getUsuarioEmailPass(String email, String password){
       return usuarioRepository.findByEmailUser(email,password);
   }

   public List<Usuario> getUsuarioRol(Long idRol){
       return usuarioRepository.findByRol(idRol);
   }

}
