package com.camacho.pract.repository;

import com.camacho.pract.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByUsername(String username);
}
