package com.example.gestor.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestor.models.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Usuario findByUsername(String user);
}
