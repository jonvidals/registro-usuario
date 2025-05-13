package com.ecomarket.registro_usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.registro_usuario.model.Usuario;
import com.ecomarket.registro_usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario crear_usuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario findById(int id) {
            return usuarioRepository.findById(id);
       
    }
}
