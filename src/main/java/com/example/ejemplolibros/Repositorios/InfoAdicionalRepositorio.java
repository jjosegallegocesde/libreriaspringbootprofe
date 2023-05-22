package com.example.ejemplolibros.Repositorios;

import com.example.ejemplolibros.entidades.InfoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoAdicionalRepositorio extends JpaRepository<InfoAdicional,Integer> {
}
