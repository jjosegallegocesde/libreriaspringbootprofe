package com.example.ejemplolibros.servicios;

import com.example.ejemplolibros.Repositorios.AutorRepositorio;
import com.example.ejemplolibros.entidades.Autor;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio implements ServicioBase<Autor> {

    @Autowired
    private AutorRepositorio autorRepositorio;


    @Override
    @Transactional(readOnly = true)
    public List<Autor> buscarTodos() throws Exception {
        try{
            List<Autor> autores = autorRepositorio.findAll();
            return autores;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Autor buscarPorId(Integer id) throws Exception {
        try{

            Optional<Autor> autorOptional = autorRepositorio.findById(id);
            if (autorOptional.isPresent()) {
                Autor autor = autorOptional.get();
                return autor;
            } else {
                throw new Exception("no existe autor con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Autor registrar(Autor autorTabla) throws Exception {
        try{

            Autor autorRegistrado = autorRepositorio.save(autorTabla);
            return autorRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor actualizar(Integer id, Autor autorTabla) throws Exception {
        try{

            Optional<Autor> autorOptional = autorRepositorio.findById(id);
            if (autorOptional.isPresent()) {
                Autor autorexistente = autorOptional.get();
                autorexistente.setNombre(autorTabla.getNombre());
                Autor autorActualizado= autorRepositorio.save(autorexistente);
                return autorActualizado;
            } else {
                throw new Exception("no existe autor con ese id");
            }
        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        try{

            Optional<Autor> autorOptional = autorRepositorio.findById(id);
            if (autorOptional.isPresent()) {
                autorRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("No existe autor con ese ID: " + id);
            }

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }
}
