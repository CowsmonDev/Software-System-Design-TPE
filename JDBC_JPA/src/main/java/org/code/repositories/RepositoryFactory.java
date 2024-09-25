package org.code.repositories;

import org.code.repositories.JPARepository.CarreraRepository;
import org.code.repositories.JPARepository.EstudianteRepository;
import org.code.repositories.JPARepository.InscripcionesRepository;

public abstract class RepositoryFactory {

    public static final int JPA = 1;

    public static RepositoryFactory getRepositoryDriver(int type, String driver) {
        switch (type) {
            case JPA:
                return JPARepositoryDriver.getInstance(driver);
            default:
                return null;
        }
    }

    public abstract CarreraRepository getCarreraRepository();

    public abstract EstudianteRepository getEstudianteRepository();

    public abstract InscripcionesRepository getInscripcionesRepository();

}
