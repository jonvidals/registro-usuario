package com.ecomarket.registro_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
    Usuario usuarioGuardado = usuarioService.crear_usuario(usuario);
    if (usuarioGuardado.getId() == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
    Usuario u = usuarioService.findById(id.intValue());
    if (u != null) {
        return ResponseEntity.ok(u);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
