package com.example.CRUD.Actividades;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioActividad extends JpaRepository<Actividades,Long> {

    Optional<Actividades> findByNombre(String nombre);
}
