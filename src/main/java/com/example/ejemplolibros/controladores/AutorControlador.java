package com.example.ejemplolibros.controladores;

import com.example.ejemplolibros.entidades.Autor;
import com.example.ejemplolibros.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autores")
public class AutorControlador {

    @Autowired
    protected AutorServicio autorServicio;

    @PostMapping
    public ResponseEntity<Autor> registrar(@RequestBody Autor datosAutor){
        try{
            Autor autorRegistrado= autorServicio.registrar(datosAutor);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(autorRegistrado);

        }catch(Exception error){
            String errorMensaje="Tenemos un error: "+error.getMessage();
            Autor autorError= new Autor();
            autorError.setErrorMessage(errorMensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(autorError);

        }
    }

    @GetMapping
    public ResponseEntity<List<Autor>> buscarTodos(){
        try{
            List<Autor> autores = autorServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autores);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }



}
