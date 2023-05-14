package com.example.ejemplolibros.entidades;


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
    private Libro libro;


    public InfoAdicional() {
    }

    public InfoAdicional(Integer id, Libro libro) {
        this.id = id;
        this.libro = libro;
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
}
