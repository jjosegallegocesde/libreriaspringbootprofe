package com.example.ejemplolibros.controladores;

import com.example.ejemplolibros.entidades.Libro;
import com.example.ejemplolibros.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/libros")
public class LibroControlador {

    @Autowired
    protected LibroServicio libroServicio;

    @PostMapping
    public ResponseEntity<Libro> registrar(@RequestBody Libro datosLibro){
        try{
            Libro libroRegistrado= libroServicio.registrar(datosLibro);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(libroRegistrado);
        }catch(Exception error){
            String errorMensaje="Tenemos un error: "+error.getMessage();
            Libro libroError= new Libro();
            libroError.setErrorMessage(errorMensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(libroError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Libro>> buscarTodos(){
        try{
            List<Libro> libros = libroServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(libros);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Libro>buscarPorNombre(@PathVariable String nombre){

        try{

            Libro libroBuscado =libroServicio.buscarPorNombre(nombre);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(libroBuscado);

        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Libro> buscarZona(@PathVariable Integer id){

        try{

            Libro libroBuscado =libroServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(libroBuscado);

        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }



}
