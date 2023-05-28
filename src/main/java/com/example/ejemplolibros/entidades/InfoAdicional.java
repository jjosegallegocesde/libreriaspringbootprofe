package com.example.ejemplolibros.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="infoAdicional")
public class InfoAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name="libro_id")
    @JsonBackReference
    private Libro libro;

    @Column(name="idioma")
    private String idioma;


    @Transient
    private String errorMessage;


    public InfoAdicional() {
    }

    public InfoAdicional(Integer id, Libro libro, String idioma) {
        this.id = id;
        this.libro = libro;
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
