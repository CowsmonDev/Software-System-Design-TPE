package org.code.services;

import org.code.models.Carrera;
import org.code.repositories.ICarreraRepository;
import org.code.repositories.JPARepository.CarreraRepository;

import java.util.List;

public class CarreraService {

    private static CarreraService instance;
    private final ICarreraRepository carreraRepository;

    private CarreraService(ICarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public static CarreraService getInstance(ICarreraRepository carreraRepository) {
        return (instance == null)
                ? instance = new CarreraService(carreraRepository)
                : instance;
    }



    public List<Carrera> getAllCarreras() {
        return (List<Carrera>) carreraRepository.findAll();
    }

    public List<Carrera> findCarerrasConEstudiantes() {
        return carreraRepository.findCarrerasConEstudiantes();
    }

    /**
     * Get Carrera by ID
     *
     * @param id Carrera ID
     * @return Carrera
     */
    public Carrera getById(int id) throws Exception {
        return carreraRepository.findById(id);
    }

    /**
     * Save Carrera
     *
     * @param carrera es la carrera que queres insertar debe tener nombre
     * @return Carrera
     */
    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    /**
     * Delete Carrera by ID
     *
     * @param id Carrera ID
     */
    public void deleteById(int id) throws Exception {
        carreraRepository.deleteById(id);
    }

    public void deleteAll() throws Exception {
        carreraRepository.deleteAll();
    }
}
