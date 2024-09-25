package org.code;

import org.code.models.Estudiante;
import org.code.repositories.JPARepositoryDriver;
import org.code.repositories.RepositoryFactory;
import org.code.services.EstudiantesService;

import java.util.ArrayList;
import java.util.List;

public class MainEstudiantes {

    public static void main(String[] args) {
        RepositoryFactory rf = RepositoryFactory.getRepositoryDriver(RepositoryFactory.JPA, JPARepositoryDriver.POSTGRES);
        EstudiantesService estudiantesService = EstudiantesService.getInstance(rf.getEstudianteRepository());

        // eliminamos todos los elementos para testear con base de datos vacia
        try {
            estudiantesService.deleteAll();
        } catch (Exception e) {
            System.out.println("Error al eliminar estudiantes: " + e.getMessage());
        }
        ///////////////////////////DAR DE ALTA ESTUDIANTES/////////////////////////////////////
        estudiantesService.inscribirEstudiante(new Estudiante("42964385", "25025", "Agustin", "Crespo", 22, "Masculino", "Tandil", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("41964385", "25023", "Dafne", "Chavez", 22, "Femenino", "Tandil", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("43964385", "25024", "Emmanuel", "Molina", 22, "Masculino", "Tandil", new ArrayList<>()));
        ///////////////////////////
        estudiantesService.inscribirEstudiante(new Estudiante("12345678", "25026", "Lucia", "Gonzalez", 21, "Femenino", "Buenos Aires", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("87654321", "25027", "Carlos", "Perez", 23, "Masculino", "Córdoba", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("11223344", "25028", "Ana", "Martinez", 20, "Femenino", "Rosario", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("44332211", "25029", "Jorge", "Fernandez", 24, "Masculino", "Mendoza", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("33445566", "25030", "Sofia", "Lopez", 22, "Femenino", "La Plata", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("66554433", "25031", "David", "Diaz", 25, "Masculino", "Mar del Plata", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("99887766", "25032", "Valentina", "Romero", 19, "Femenino", "Salta", new ArrayList<>()));
        estudiantesService.inscribirEstudiante(new Estudiante("77665544", "25033", "Mateo", "Silva", 21, "Masculino", "Neuquén", new ArrayList<>()));
        ////////////////////////////////////////////

        List<Estudiante> eList = estudiantesService.getAll();
        ///////////////////RECUPERAR TODOS LOS ESTUDIANTES///////////////////////

        System.out.println();
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println("IMPRIMIENDO TODOS LOS ESTUDIANTES");
        eList.forEach(System.out::println);
        System.out.println("FIN DE IMPRESION DE TODOS LOS ESTUDIANTES");
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println();


        ////////RECUPERAR CON CRITERIO///////////////////////////
        try {
            Estudiante agustin = estudiantesService.getById("42964385");
            Estudiante dafne = estudiantesService.getById("41964385");
            Estudiante emmanuel = estudiantesService.getById("43964385");
            System.out.println();
            System.out.println("IMPRIMIENDO ESTUDIANTES POR ID");
            System.out.println("numero de DNI seleccionado: 42964385");
            System.out.println();
            System.out.println(agustin);
            System.out.println("numero de DNI seleccionado: 41964385");
            System.out.println();
            System.out.println(dafne);
            System.out.println("numero de DNI seleccionado: 43964385");
            System.out.println();
            System.out.println(emmanuel);
            System.out.println("FIN DE IMPRESION DE ESTUDIANTES POR ID");
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //////////////RECUPERAR ESTUDIANTE POR NUMERO DE LIBRETA///////////////////

        try {
            Estudiante agustin = estudiantesService.getByNumeroLibreta("25025");
            System.out.println();
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println("IMPRIMIENDO ESTUDIANTES POR NUMERO DE LIBRETA");
            System.out.println("numero de libreta seleccionado: 25025");
            System.out.println();
            System.out.println(agustin);
            System.out.println("FIN DE IMPRESION DE ESTUDIANTES POR NUMERO DE LIBRETA");
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        /////////////RECUPERAR ESTUDIANTES POR GENERO////////////////////////


        try {

            System.out.println();
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println("IMPRIMIENDO ESTUDIANTES POR GENERO");
            System.out.println("GENERO SELECCIONADO: Masculino");
            System.out.println();
            estudiantesService.getByGenero("Masculino").forEach(System.out::println);
            System.out.println("FIN DE IMPRESION DE ESTUDIANTES POR GENERO");
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        // Eliminando a agustin
        try {
            System.out.println();
            System.out.println("Eliminando a Agustin");
            estudiantesService.deleteById("42964385");
            System.out.println("Agustin eliminado");
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error al eliminar a Agustin");
            System.out.println();
            throw new RuntimeException(e);
        }

        try {
            Estudiante agustin = estudiantesService.getById("42964385");
            System.out.println(agustin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }



        //JPARepositoryConnection.close();
    }

}
