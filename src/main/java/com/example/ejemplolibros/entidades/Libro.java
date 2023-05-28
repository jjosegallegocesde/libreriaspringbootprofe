package com.example.ejemplolibros.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="editorial_id")
    private Editorial editorial;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="calificacion")
    private Integer calificacion;

    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL)
    @JsonManagedReference
    private InfoAdicional infoAdicional;

    @Transient
    private String errorMessage;

    public Libro() {
    }

    public Libro(Integer id, Categoria categoria, Editorial editorial, String titulo, String descripcion, Integer calificacion, InfoAdicional infoAdicional) {
        this.id = id;
        this.categoria = categoria;
        this.editorial = editorial;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.infoAdicional = infoAdicional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(InfoAdicional infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
