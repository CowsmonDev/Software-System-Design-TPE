package org.code.repositories;

import org.code.repositories.JPARepository.CarreraRepository;
import org.code.repositories.JPARepository.EstudianteRepository;
import org.code.repositories.JPARepository.InscripcionesRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPARepositoryDriver extends RepositoryFactory {

    public static final String POSTGRES = "Postgres";

    private static JPARepositoryDriver instance;


    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    public static JPARepositoryDriver getInstance(String driver) {
        if (instance == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(driver);
            entityManager = entityManagerFactory.createEntityManager();
            instance = new JPARepositoryDriver();
        }
        return instance;
    }

    public static EntityManager getEntityManager(){
        return entityManager;
    }

    @Override
    public CarreraRepository getCarreraRepository() {
        return CarreraRepository.getInstance(entityManager);
    }

    @Override
    public EstudianteRepository getEstudianteRepository() {
        return EstudianteRepository.getInstance(entityManager);
    }

    @Override
    public InscripcionesRepository getInscripcionesRepository() {
        return InscripcionesRepository.getInstance(entityManager);
    }

    public static void close() {
        entityManager.close();
        entityManagerFactory.close();
        instance = null;
    }

}
