package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Estado;
import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario1));

        Optional<Usuario> result = usuarioService.getUsuario(anyLong());

        verify(usuarioRepository, times(1)).findById(anyLong());
        assertTrue(result.isPresent());
        assertEquals(usuario1, result.orElse(null));
    }

    @Test
    void saveOrUpdate() {
        Usuario usuario2 = new Usuario(16L,"Second Test","Last name Second test","35555","123","secondTest@gmail.com",estado);

        //when
        usuarioService.saveOrUpdate(usuario2);

        //then
        ArgumentCaptor<Usuario> usuarioArgumentCaptor = ArgumentCaptor.forClass(Usuario.class);
        verify(usuarioRepository).save(usuarioArgumentCaptor.capture());

       Usuario capturedUsuario = usuarioArgumentCaptor.getValue();
       assertThat(capturedUsuario).isEqualTo(usuario2);
    }

    @Test
    void delete() {
        Long idUsuario = 10L;

        //when
        usuarioService.delete(idUsuario);

        //then
        verify(usuarioRepository, times(1)).deleteById(idUsuario);
    }

    @Test
    void getUsuarioEmailPass() {
        String email = "emailTest@gmail.com";
        String password = "123";

        when(usuarioRepository.findByEmailUser(email,password)).thenReturn(Optional.of(usuario));
        Optional<Usuario> result = usuarioService.getUsuarioEmailPass(email,password);

        verify(usuarioRepository, times(1)).findByEmailUser(email,password);
        assertTrue(result.isPresent());
        assertEquals(usuario, result.orElse(null));
    }

    @Test
    void getUsuarioRol() {
        Long idRol = 4L;
        List<Usuario> usuarios = Arrays.asList(usuario);

        when(usuarioRepository.findByRol(idRol)).thenReturn(usuarios);

        List<Usuario> result = usuarioService.getUsuarioRol(idRol);

        verify(usuarioRepository, times(1)).findByRol(idRol);
        assertEquals(1, result.size());
        assertEquals(usuario, result.get(0));
    }
}