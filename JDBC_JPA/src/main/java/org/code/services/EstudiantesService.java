package org.code.services;

import org.code.models.Carrera;
import org.code.models.Estudiante;
import org.code.repositories.IEstudianteRepository;
import org.code.repositories.JPARepository.EstudianteRepository;

import java.util.List;

public class EstudiantesService {

    private final IEstudianteRepository estudiantesRepository;

    private static EstudiantesService instance;

    private EstudiantesService(IEstudianteRepository estudiantesRepository) {
        this.estudiantesRepository = estudiantesRepository;
    }

    public static EstudiantesService getInstance(IEstudianteRepository estudiantesRepository) {
        return (instance == null)
                ? instance = new EstudiantesService(estudiantesRepository)
                : instance;
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        estudiantesRepository.save(estudiante);
    }

    public Estudiante getById(String numeroDocumento) throws Exception {
        return estudiantesRepository.findById(numeroDocumento);
    }

    public List<Estudiante> getAll() {
        return (List<Estudiante>) estudiantesRepository.findAll();
    }

    public Estudiante getByNumeroLibreta(String numeroLibreta) throws Exception {
        return estudiantesRepository.findEstudianteByNumeroLibreta(numeroLibreta);
    }

    public List<Estudiante> getByGenero(String genero) throws Exception {
        return estudiantesRepository.findEstudiantesByGenero(genero);
    }

    public List<Estudiante> getByCiudadResidenciaYCarrera(String ciudadResidencia, Carrera carrera){
        return estudiantesRepository.findEstudiantesByCiudadResidenciaAndCarrera(ciudadResidencia, carrera);
    }

    public void deleteAll() throws Exception {
        estudiantesRepository.deleteAll();
    }

    public void deleteById(String id) throws Exception {
        estudiantesRepository.deleteById(id);
    }
}
