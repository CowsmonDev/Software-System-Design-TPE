package org.code;

import org.code.models.Carrera;
import org.code.models.Estudiante;
import org.code.repositories.JPARepositoryDriver;
import org.code.repositories.RepositoryFactory;
import org.code.services.CarreraService;
import org.code.services.EstudiantesService;
import org.code.services.InscripcionesService;

import java.util.List;

public class MainInscripciones {
    public static void main(String[] args) {
        RepositoryFactory rf = RepositoryFactory.getRepositoryDriver(RepositoryFactory.JPA, JPARepositoryDriver.POSTGRES);

        EstudiantesService estudiantesService = EstudiantesService.getInstance(rf.getEstudianteRepository());
        CarreraService carreraService = CarreraService.getInstance(rf.getCarreraRepository());
        InscripcionesService inscripcionesService = InscripcionesService.getInstance(rf.getInscripcionesRepository());

        try {
            inscripcionesService.deleteAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Estudiante> eList = estudiantesService.getAll();
        List<Carrera> cList = carreraService.getAllCarreras();

        ////////////////////MATRICULAR ESTUDIANTES EN UNA CARRERA (INSCRIPCION)//////////////////
        inscripcionesService.inscribirAlumno(eList.getFirst(), cList.getFirst());
        inscripcionesService.inscribirAlumnoAnio(eList.get(1),cList.getFirst(),2005);
        inscripcionesService.inscribirAlumnoAnio(eList.get(2),cList.getFirst(),2001);
        inscripcionesService.inscribirAlumnoAnio(eList.get(3),cList.getFirst(),2003);
        inscripcionesService.inscribirAlumnoAnio(eList.get(4),cList.get(2),2005);
        inscripcionesService.inscribirAlumnoAnio(eList.get(5),cList.get(2),2001);
        inscripcionesService.inscribirAlumnoAnio(eList.get(6),cList.get(2),2003);
        inscripcionesService.inscribirAlumnoAnio(eList.get(7),cList.getLast(),2001);
        inscripcionesService.inscribirAlumnoAnio(eList.get(8),cList.get(1),2010);
        inscripcionesService.inscribirAlumno(eList.getLast(), cList.getFirst());
        inscripcionesService.inscribirAlumno(eList.getLast(), cList.getLast());



        inscripcionesService.getAll().forEach(System.out::println);

        System.out.println();
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println("IMPRIMIENTO CARRERAS CON ESTUDIANTES");

        //System.out.println("Contiene " + carrera.getInscripciones().size() + " alumnos");
        carreraService.findCarerrasConEstudiantes().forEach(System.out::println);
        System.out.println("FIN DE IMPRESION DE CARRERAS CON ESTUDIANTES");
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println();


        //////////RECUPERAR ESTUDIANTES CON CIERTA CARRERA FILTRADO POR CIUDAD DE RESIDENCIA////////////////////////////

        System.out.println();
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println("RECUPERAR ESTUDIANTES CON CIERTA CARRERA FILTRADO POR CIUDAD DE RESIDENCIA");
        System.out.println("CIUDAD SELECCIONADA: Salta");
        System.out.println("CARRERA SELECCIONADA: LA PRIMERA EN LA TABLA, EN ESTE CASO "+ cList.get(1).getNombre());
        System.out.println();
        estudiantesService.getByCiudadResidenciaYCarrera("Salta",cList.get(1));
        System.out.println("FIN DE RECUPERAR ESTUDIANTES CON CIERTA CARRERA FILTRADO POR CIUDAD DE RESIDENCIA");
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println();







        /////////////////////


        System.out.println();
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println("REPORTE DE CARRERAS");
        inscripcionesService.crearReporteDeCarreras();
        System.out.println("FIN DE REPORTE DE CARRERAS");
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println();


        /////////////////////////
        //JPARepositoryDriver.close();
    }
}
