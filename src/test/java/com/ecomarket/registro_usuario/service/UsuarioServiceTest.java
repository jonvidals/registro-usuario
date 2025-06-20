package com.ecomarket.registro_usuario.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;

import com.ecomarket.registro_usuario.repository.UsuarioRepository;

import com.ecomarket.registro_usuario.model.Usuario;

public class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;
    @Mock
    private UsuarioRepository usuarioRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testRegistrarUsuario() {
        Usuario usuario = new Usuario(null, "2222", "jona", "vidal", "jon@cftla.cl", "xd123", 0, true);
        Usuario usuarioGuardado = new Usuario(1L, "2222", "jona", "vidal", "jon@cftla.cl", "xd123", 0, true);
    
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGuardado);
    
        Usuario resultado = usuarioService.crear_usuario(usuario);
    
        assertThat(resultado.getId()).isEqualTo(1L);
        verify(usuarioRepository).save(usuario);
    }




}
