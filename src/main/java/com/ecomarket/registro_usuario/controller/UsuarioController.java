package com.ecomarket.registro_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.registro_usuario.model.Usuario;
import com.ecomarket.registro_usuario.service.UsuarioService;

@RequestMapping("/api/usuario")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public String registrarUsuario(Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "Usuario registrado exitosamente";
    }




}
