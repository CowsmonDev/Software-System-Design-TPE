package org.code.repositories;

import org.code.models.Carrera;
import org.code.models.Estudiante;

import java.util.List;

public interface IEstudianteRepository extends IRepository<Estudiante, String>{

    Estudiante findEstudianteByNumeroLibreta(String numeroLibreta) throws Exception;

    List<Estudiante> findEstudiantesByGenero(String genero);

    List<Estudiante> findEstudiantesByCiudadResidenciaAndCarrera(String ciudadResidencia, Carrera carrera);
}
