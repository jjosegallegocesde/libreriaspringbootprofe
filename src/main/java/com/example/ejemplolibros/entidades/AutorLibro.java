package com.example.ejemplolibros.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="autorLibro")
public class AutorLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="libro_id")
    private Libro libro;

    public AutorLibro() {
    }

    public AutorLibro(Autor autor, Libro libro) {
        this.autor = autor;
        this.libro = libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
