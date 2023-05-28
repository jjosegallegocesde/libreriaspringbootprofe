package com.example.ejemplolibros.servicios;

import com.example.ejemplolibros.Repositorios.AutorLibroRepositorio;
import com.example.ejemplolibros.entidades.AutorLibro;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorLibroServicio implements ServicioBase<AutorLibro> {

    @Autowired
    protected AutorLibroRepositorio autorLibroRepositorio;


    @Override
    public List<AutorLibro> buscarTodos() throws Exception {
        try{
            List<AutorLibro> autorLibros = autorLibroRepositorio.findAll();
            return autorLibros;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public AutorLibro buscarPorId(Integer id) throws Exception {
        try{

            Optional<AutorLibro> autorLibroOptional = autorLibroRepositorio.findById(id);
            if (autorLibroOptional.isPresent()) {
                AutorLibro autorLibro = autorLibroOptional.get();
                return autorLibro;
            } else {
                throw new Exception("no existe registro con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public AutorLibro registrar(AutorLibro entidad) throws Exception {
        try{
            AutorLibro autorLibroRegistrado = autorLibroRepositorio.save(entidad);
            return autorLibroRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public AutorLibro actualizar(Integer id, AutorLibro entidad) throws Exception {
        return null;
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }
}
