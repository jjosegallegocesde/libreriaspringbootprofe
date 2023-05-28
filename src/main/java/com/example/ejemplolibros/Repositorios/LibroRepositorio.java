package com.example.ejemplolibros.Repositorios;

import com.example.ejemplolibros.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Integer> {

    Optional<Libro> findByTitulo (String nombre);


}
