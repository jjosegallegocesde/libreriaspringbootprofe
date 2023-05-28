package com.example.ejemplolibros.controladores;

import com.example.ejemplolibros.entidades.InfoAdicional;
import com.example.ejemplolibros.entidades.Libro;
import com.example.ejemplolibros.servicios.InfoAdicionalServicio;
import com.example.ejemplolibros.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/informacion")
public class InfoAdicionalControlador {

    @Autowired
    protected InfoAdicionalServicio infoAdicionalServicio;

    @PostMapping
    public ResponseEntity<InfoAdicional> registrar(@RequestBody InfoAdicional datosAdicionales){
        try{
            InfoAdicional infoAdicionalregistrada= infoAdicionalServicio.registrar(datosAdicionales);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(infoAdicionalregistrada);
        }catch(Exception error){
            String errorMensaje="Tenemos un error: "+error.getMessage();
            InfoAdicional libroError= new InfoAdicional();
            libroError.setErrorMessage(errorMensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(libroError);
        }
    }


}
