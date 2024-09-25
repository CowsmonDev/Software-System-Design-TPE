package org.code.models;

import javax.persistence.*;
import java.util.List;

import org.code.models.Inscripciones;

@Entity
public class Estudiante {

    @Id
    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "numero_libreta")
    private String numeroLibreta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripciones> inscripciones;


    public Estudiante() {
    }

    public Estudiante(String numeroDocumento, String numeroLibreta, String nombre, String apellido, int edad, String genero, String ciudadResidencia, List<Inscripciones> inscripciones) {
        this.numeroDocumento = numeroDocumento;
        this.numeroLibreta = numeroLibreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.inscripciones = inscripciones;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNumeroLibreta() {
        return numeroLibreta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public List<Inscripciones> getInscripciones() {
        return inscripciones;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setNumeroLibreta(String numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "\n numeroDocumento='" + numeroDocumento + '\'' +
                ",\n numeroLibreta='" + numeroLibreta + '\'' +
                ",\n nombre='" + nombre + '\'' +
                ",\n apellido='" + apellido + '\'' +
                ",\n edad=" + edad +
                ",\n genero='" + genero + '\'' +
                ",\n ciudadResidencia='" + ciudadResidencia + '\'' +
                ",\n inscripciones=" + inscripciones +
                "\n}";

    }
}


