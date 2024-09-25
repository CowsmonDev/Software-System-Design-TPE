package org.code.repositories;

import org.code.models.Carrera;

import java.util.List;

public interface ICarreraRepository extends IRepository<Carrera, Integer> {
    List<Carrera> findCarrerasConEstudiantes();
}
