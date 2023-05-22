package com.example.ejemplolibros.servicios;


import com.example.ejemplolibros.Repositorios.LibroRepositorio;
import com.example.ejemplolibros.entidades.Editorial;
import com.example.ejemplolibros.entidades.Libro;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio implements ServicioBase<Libro> {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> buscarTodos() throws Exception {
        try{
            List<Libro> libros = libroRepositorio.findAll();
            return libros;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Libro buscarPorId(Integer id) throws Exception {
        try{

            Optional<Libro> libroOptional = libroRepositorio.findById(id);
            if (libroOptional.isPresent()) {
                Libro libro = libroOptional.get();
                return libro;
            } else {
                throw new Exception("no existe editorial con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Libro registrar(Libro entidad) throws Exception {
        try{
            Libro libroRegistrado = libroRepositorio.save(entidad);
            return libroRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Libro actualizar(Integer id, Libro entidad) throws Exception {
        try{

            Optional<Libro> libroOptional = libroRepositorio.findById(id);
            if (libroOptional.isPresent()) {
                Libro libroexistente = libroOptional.get();
                libroexistente.setDescripcion(entidad.getDescripcion());
                Libro libroActualizado= libroRepositorio.save(libroexistente);
                return libroActualizado;
            } else {
                throw new Exception("no existe editorial con ese id");
            }
        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }
}
