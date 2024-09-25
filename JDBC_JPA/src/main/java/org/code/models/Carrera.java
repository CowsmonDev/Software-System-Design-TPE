package org.code.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripciones> inscripciones;

    public Carrera() {
    }

    public Carrera(String nombre, List<Inscripciones> inscripciones) {
        this.nombre = nombre;
        this.inscripciones = inscripciones;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Inscripciones> getInscripciones() {
        return inscripciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera: {" +
                "\n id: " + id + "," +
                "\n nombre: " + nombre +
                "\n}";
    }
}
