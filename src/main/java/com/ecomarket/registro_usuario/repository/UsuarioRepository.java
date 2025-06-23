package com.ecomarket.registro_usuario.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.registro_usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @SuppressWarnings("unchecked")
    Usuario save(Usuario usuario);

    Usuario findById(long id);
}
