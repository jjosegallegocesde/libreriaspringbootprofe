package com.example.ejemplolibros.servicios;

import com.example.ejemplolibros.entidades.Categoria;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio implements ServicioBase<Categoria> {
    
    @Override
    public List<Categoria> buscarTodos() throws Exception {
        return null;
    }

    @Override
    public Categoria buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Categoria registrar(Categoria entidad) throws Exception {
        return null;
    }

    @Override
    public Categoria actualizar(Integer id, Categoria entidad) throws Exception {
        return null;
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }
}
