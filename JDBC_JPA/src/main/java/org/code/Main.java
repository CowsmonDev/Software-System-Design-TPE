package org.code;


import org.code.repositories.JPARepositoryDriver;
import org.code.repositories.RepositoryFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RepositoryFactory rf = RepositoryFactory.getRepositoryDriver(RepositoryFactory.JPA, JPARepositoryDriver.POSTGRES);
        MainEstudiantes.main(args);
        MainCarrera.main(args);
        MainInscripciones.main(args);
        JPARepositoryDriver.close();

    }


}