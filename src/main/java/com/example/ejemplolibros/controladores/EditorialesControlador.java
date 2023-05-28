package com.example.ejemplolibros.controladores;

import com.example.ejemplolibros.entidades.Categoria;
import com.example.ejemplolibros.entidades.Editorial;
import com.example.ejemplolibros.servicios.CategoriaServicio;
import com.example.ejemplolibros.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/editoriales")
public class EditorialesControlador {

    @Autowired
    protected EditorialServicio editorialServicio;

    @PostMapping
    public ResponseEntity<Editorial> registrar(@RequestBody Editorial datosEditorial){
        try{
            Editorial editorialRegistrado= editorialServicio.registrar(datosEditorial);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(editorialRegistrado);
        }catch(Exception error){
            String errorMensaje="Tenemos un error: "+error.getMessage();
            Editorial editorialError= new Editorial();
            editorialError.setErrorMessage(errorMensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(editorialError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Editorial>> buscarTodos(){
        try{
            List<Editorial> editoriales = editorialServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editoriales);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
