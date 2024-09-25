package org.code;

import org.code.models.Carrera;
import org.code.repositories.JPARepositoryDriver;
import org.code.repositories.RepositoryFactory;
import org.code.services.CarreraService;

import java.util.ArrayList;
import java.util.List;

public class MainCarrera {

    public static void main(String[] args) {
        RepositoryFactory rf = RepositoryFactory.getRepositoryDriver(RepositoryFactory.JPA, JPARepositoryDriver.POSTGRES);

        CarreraService carreraService = CarreraService.getInstance(rf.getCarreraRepository());
        try {
            carreraService.deleteAll();
        } catch (Exception e) {
            System.out.println("Error al eliminar carreras: " + e.getMessage());
        }

        carreraService.save(new Carrera("Ingenieria en Sistemas", new ArrayList<>()));
        carreraService.save(new Carrera("Ingenieria en Alimentos", new ArrayList<>()));
        carreraService.save(new Carrera("Ingenieria Quimica", new ArrayList<>()));
        carreraService.save(new Carrera("Ingenieria Civil", new ArrayList<>()));
        carreraService.save(new Carrera("Ingenieria Industrial", new ArrayList<>()));

        List<Carrera> cList = carreraService.getAllCarreras();

        System.out.println();
        System.out.println("IMPRIMIENDO TODAS LAS CARRERAS");
        cList.forEach(System.out::println);
        System.out.println("FIN DE IMPRESION DE TODAS LAS CARRERAS");
        System.out.println();

        try {
            Carrera c = carreraService.getById(cList.getFirst().getId());
            System.out.println();
            System.out.println("IMPRIMIENDO CARRERA POR ID");
            System.out.println("ID SELECCIONADO: 1");
            System.out.println();
            System.out.println(c);
            System.out.println("FIN DE IMPRESION DE CARRERA POR ID");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
/*
        System.out.println();
        System.out.println("IMPRIMIENTO CARRERAS CON ESTUDIANTES");
        carreraService.findCarerrasConEstudiantes().forEach(System.out::println);
        System.out.println("FIN DE IMPRESION DE CARRERAS CON ESTUDIANTES");
        System.out.println();
*/
        System.out.println("Eliminando carrera con Id:" + cList.getLast().getId() + " y Nombre: " + cList.getLast().getNombre());
        try {
            carreraService.deleteById(cList.getLast().getId());
            System.out.println("Carrera eliminada");
        } catch (Exception e) {
            System.out.println("Error al eliminar carrera: " + e.getMessage());
        }


        try {
            Carrera c = cList.getLast();
            cList.removeLast();
            carreraService.getById(c.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //JPARepositoryDriver.close();
    }

}
