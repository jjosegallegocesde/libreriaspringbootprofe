package com.example.ejemplolibros.Repositorios;

import com.example.ejemplolibros.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,Integer> {
}
