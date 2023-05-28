package com.example.ejemplolibros.controladores;

import com.example.ejemplolibros.entidades.Autor;
import com.example.ejemplolibros.entidades.Categoria;
import com.example.ejemplolibros.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaControlador {

    @Autowired
    protected CategoriaServicio categoriaServicio;

    @PostMapping
    public ResponseEntity<Categoria> registrar(@RequestBody Categoria datosCategoria){
        try{
            Categoria categoriaRegistrado= categoriaServicio.registrar(datosCategoria);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(categoriaRegistrado);
        }catch(Exception error){
            String errorMensaje="Tenemos un error: "+error.getMessage();
            Categoria categoriaError= new Categoria();
            categoriaError.setErrorMessage(errorMensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(categoriaError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos(){
        try{
            List<Categoria> categorias = categoriaServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categorias);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
