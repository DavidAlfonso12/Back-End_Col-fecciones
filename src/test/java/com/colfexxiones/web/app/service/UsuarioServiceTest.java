package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Estado;
import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    private  Estado estado;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        estado = new Estado(9L,"Test");
        usuario = new Usuario();
        usuario.setIdUsuario(99L);
        usuario.setUsuario_nombre("First Test");
        usuario.setUsuario_apellido("Last name First test");
        usuario.setUsuario_telefono("35555");
        usuario.setUsuario_password("123");
        usuario.setEstado(estado);
        usuario.setUsuario_email("firstTest@gmail.com");

        }

    @Test
    void getUsuarios() {

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        List<Usuario> result = usuarioService.getUsuarios();

        verify(usuarioRepository, times(1)).findAll();
        assertEquals(1, result.size());
    }

    @Test
    void getUsuario() {
        Usuario usuario1 = new Usuario(15L,"First Test","Last name First test","35555","123","firstTest@gmail.com",estado);
        when(usuarioRepository.findById(15L)).thenReturn(Optional.of(usuario1));

        Optional<Usuario> result = usuarioService.getUsuario(15L);

        verify(usuarioRepository, times(1)).findById(15L);
        assertTrue(result.isPresent());
        assertEquals(usuario1, result.get());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void delete() {
    }

    @Test
    void getUsuarioEmailPass() {
    }

    @Test
    void getUsuarioRol() {
    }
}