package com.example.ejemplolibros.servicios;

import com.example.ejemplolibros.Repositorios.InfoAdicionalRepositorio;
import com.example.ejemplolibros.entidades.InfoAdicional;
import com.example.ejemplolibros.entidades.Libro;
import com.example.ejemplolibros.servicios.base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoAdicionalServicio implements ServicioBase<InfoAdicional> {

    @Autowired
    private InfoAdicionalRepositorio infoAdicionalRepositorio;

    @Override
    public List<InfoAdicional> buscarTodos() throws Exception {
        return null;
    }

    @Override
    public InfoAdicional buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public InfoAdicional registrar(InfoAdicional entidad) throws Exception {
        try{
            InfoAdicional InfoAdicionalRegistrado = infoAdicionalRepositorio.save(entidad);
            return InfoAdicionalRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public InfoAdicional actualizar(Integer id, InfoAdicional entidad) throws Exception {
        return null;
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }
}
