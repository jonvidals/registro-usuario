package com.ecomarket.registro_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){

   
        Usuario u = usuarioService.findById(usuario.getId().intValue());
        if(u == null){
            return new ResponseEntity<>(usuarioService.crear_usuario(usuario), HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        }
    }
}
