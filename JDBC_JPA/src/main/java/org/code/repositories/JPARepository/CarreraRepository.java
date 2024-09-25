package org.code.repositories.JPARepository;

import org.code.models.Carrera;
import org.code.repositories.ICarreraRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraRepository extends Repository<Carrera, Integer> implements ICarreraRepository {

    private static CarreraRepository instance;

    private CarreraRepository(EntityManager em) {
        super(Carrera.class, Integer.class, em);
    }

    public static CarreraRepository getInstance(EntityManager em) {
        return (instance == null)
                ? instance = new CarreraRepository(em)
                : instance;
    }

    /**
     * Find all Carreras with Estudiantes and order by count of Estudiantes
     *
     * @return List of Carreras
     */
    @Override
    public List<Carrera> findCarrerasConEstudiantes() {
        this.em.getTransaction().begin();
        List<Carrera> carreras = this.em.createQuery(
                "SELECT c FROM Carrera c JOIN c.inscripciones i GROUP BY c ORDER BY COUNT(i) DESC", Carrera.class
        ).getResultList();
        this.em.getTransaction().commit();
        return carreras;
    }

    @Override
    public void deleteAll() throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.createQuery("DELETE FROM Inscripciones").executeUpdate();
            this.em.getTransaction().commit();
            super.deleteAll();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new Exception(e);
        }
    }


}
