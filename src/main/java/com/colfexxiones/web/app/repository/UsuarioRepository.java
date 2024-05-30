package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.entity.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.usuario_email = :usuario_email and " +
            "u.usuario_password = :usuario_password")
    Optional<Usuario> findByEmailUser(@Param("usuario_email") String email,@Param("usuario_password")String password);

    @Query("SELECT Vendedores FROM Usuario Vendedores WHERE Vendedores.rol.idRol = :rol")
    List<Usuario> findByRol(@Param("rol")Long idRol);

}
