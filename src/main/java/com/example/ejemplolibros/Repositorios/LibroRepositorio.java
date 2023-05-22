package com.example.ejemplolibros.Repositorios;

import com.example.ejemplolibros.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Integer> {



}
