package com.ecomarket.registro_usuario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecomarket.registro_usuario.model.Usuario;

@Repository
public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario registrarse(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

}
