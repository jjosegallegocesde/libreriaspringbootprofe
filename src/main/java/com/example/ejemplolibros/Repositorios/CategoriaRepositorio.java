package com.example.ejemplolibros.Repositorios;

import com.example.ejemplolibros.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {
}
