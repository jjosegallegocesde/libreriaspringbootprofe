package com.example.ejemplolibros.Repositorios;

import com.example.ejemplolibros.entidades.AutorLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorLibroRepositorio extends JpaRepository<AutorLibro,Integer> {
}
