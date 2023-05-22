package com.example.ejemplolibros.servicios;

import com.example.ejemplolibros.Repositorios.EditorialRepositorio;
import com.example.ejemplolibros.entidades.Autor;
import com.example.ejemplolibros.entidades.Editorial;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicio implements ServicioBase<Editorial> {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List buscarTodos() throws Exception {
        try{
            List<Editorial> editoriales = editorialRepositorio.findAll();
            return editoriales;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Editorial buscarPorId(Integer id) throws Exception {
        try{

            Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
            if (editorialOptional.isPresent()) {
                Editorial editorial = editorialOptional.get();
                return editorial;
            } else {
                throw new Exception("no existe editorial con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Editorial registrar(Editorial entidad) throws Exception {
        try{
            Editorial editorialRegistrado = editorialRepositorio.save(entidad);
            return editorialRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Editorial actualizar(Integer id, Editorial entidad) throws Exception {
        try{

            Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
            if (editorialOptional.isPresent()) {
                Editorial editorialexistente = editorialOptional.get();
                editorialexistente.setNombre(entidad.getNombre());
                Editorial editorialActualizado= editorialRepositorio.save(editorialexistente);
                return editorialActualizado;
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
