package com.ecomarket.registro_usuario.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ecomarket.registro_usuario.model.Usuario;
import com.ecomarket.registro_usuario.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void testRegistrarUsuario() throws Exception {
        Usuario usuario = new Usuario(1L, "12345678-9", "jonathan", "vidal", "jonvidal@duocuc.cl", "clave123", 1, true);
        when(usuarioService.crear_usuario(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(post("/api/usuario/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.rut").value("12345678-9"))
                .andExpect(jsonPath("$.nombre").value("jonathan"))
                .andExpect(jsonPath("$.apellido").value("vidal"))
                .andExpect(jsonPath("$.email").value("jonvidal@duocuc.cl"))
                .andExpect(jsonPath("$.password").value("clave123"))
                .andExpect(jsonPath("$.rol").value(1))
                .andExpect(jsonPath("$.activo").value(true));
    }

    @Test
    void testGetMappingUsuario() throws Exception {
        Usuario usuario = new Usuario(1L, "12345678-9", "jonathan", "vidal", "jonvidal@duocuc.cl", "clave123", 1, true);
        when(usuarioService.findById(any(Long.class))).thenReturn(usuario);

        mockMvc.perform(get("/api/usuario/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.rut").value("12345678-9"))
                .andExpect(jsonPath("$.nombre").value("jonathan"))
                .andExpect(jsonPath("$.apellido").value("vidal"))
                .andExpect(jsonPath("$.email").value("jonvidal@duocuc.cl"))
                .andExpect(jsonPath("$.password").value("clave123"))
                .andExpect(jsonPath("$.rol").value(1))
                .andExpect(jsonPath("$.activo").value(true));
    }

    @Test
    void testRegistrarUsuarioError500() throws Exception {
        Usuario usuario = new Usuario(null, "12345678-9", "jonathan", "vidal", "jonvidal@duocuc.cl", "clave123", 1,
                true);
        when(usuarioService.crear_usuario(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(post("/api/usuario/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testGetUsuarioNotFound() throws Exception {
        when(usuarioService.findById(any(Integer.class))).thenReturn(null);

        mockMvc.perform(get("/api/usuario/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}