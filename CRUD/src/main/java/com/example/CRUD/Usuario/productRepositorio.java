package com.example.CRUD.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface productRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);
}
