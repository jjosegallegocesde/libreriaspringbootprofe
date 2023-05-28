package com.example.ejemplolibros.servicios;

import com.example.ejemplolibros.Repositorios.CategoriaRepositorio;
import com.example.ejemplolibros.entidades.Autor;
import com.example.ejemplolibros.entidades.Categoria;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio implements ServicioBase<Categoria> {

    @Autowired
    protected CategoriaRepositorio categoriaRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> buscarTodos() throws Exception {
        try{
            List<Categoria> categorias= categoriaRepositorio.findAll();
            return categorias;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Integer id) throws Exception {
        try{

            Optional<Categoria> categoriaOptional = categoriaRepositorio.findById(id);
            if (categoriaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();
                return categoria;
            } else {
                throw new Exception("no existe categoria con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria registrar(Categoria entidad) throws Exception {
        try{
            Categoria categoriaRegistrado = categoriaRepositorio.save(entidad);
            return categoriaRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
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
