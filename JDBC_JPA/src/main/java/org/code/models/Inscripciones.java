package org.code.models;

import org.code.models.serializers.InscripcionesId;

import javax.persistence.*;

@Entity
public class Inscripciones {

    @EmbeddedId
    private InscripcionesId id;

    @ManyToOne
    @MapsId("numeroDocumento")
    @JoinColumn(name = "numero_documento")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idCarrera")
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @Column(name = "anio_ingreso")
    private int anioIngreso;

    @Column(name = "graduado")
    private boolean graduado;

    public Inscripciones() {
    }

    public Inscripciones(Estudiante estudiante, Carrera carrera, int anioIngreso, boolean graduado) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
        this.graduado = graduado;
        this.id = new InscripcionesId(estudiante.getNumeroDocumento(), carrera.getId());
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "Inscripciones{" +
                " \n estudiante=" + estudiante.getNumeroDocumento() +
                ",\n carrera=" + carrera.getNombre() +
                ",\n anioIngreso=" + anioIngreso +
                ",\n graduado=" + graduado +
                "\n}";
    }
}
