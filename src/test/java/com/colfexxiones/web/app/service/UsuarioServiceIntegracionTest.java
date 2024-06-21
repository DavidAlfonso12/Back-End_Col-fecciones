package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.entity.Estado;
import com.colfexxiones.web.app.entity.Rol;
import com.colfexxiones.web.app.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioServiceIntegracionTest {

    @Autowired
    private MockMvc mockMvc;

    private Usuario usuario;

    private Estado estado;
    private Rol rol;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        estado = new Estado(9L,"Test");
        rol = new Rol(1L,"usuario");
        usuario = new Usuario();
        usuario.setIdUsuario(99L);
        usuario.setUsuario_nombre("First Test");
        usuario.setUsuario_apellido("Last name First test");
        usuario.setUsuario_telefono("35555");
        usuario.setUsuario_password("123");
        usuario.setEstado(estado);
        usuario.setRol(rol);
        usuario.setUsuario_email("firstTest@gmail.com");
    }

    @Test
    public void testGetAllUsuarios() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/usuarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/usuarios/login")
                        .queryParam("usuario_email", "usu@gmail.com")
                        .queryParam("usuario_password", "123Eee")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.usuario_nombre").value("Jose David"));
    }

    @Test
    public void testGetByRolUser() throws Exception {
        Rol rol = usuario.getRol();
        Long idRol = rol.getIdRol();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/usuarios/rol/{idRol}", idRol)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].usuario_nombre").value("Jose David"));
    }
}
