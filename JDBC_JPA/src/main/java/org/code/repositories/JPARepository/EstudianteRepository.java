package org.code.repositories.JPARepository;

import org.code.models.Carrera;
import org.code.models.Estudiante;
import org.code.repositories.IEstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EstudianteRepository extends Repository<Estudiante, String> implements IEstudianteRepository {

    private static EstudianteRepository instance;

    private EstudianteRepository(EntityManager em) {
        super(Estudiante.class, String.class, em);
    }

    public static EstudianteRepository getInstance(EntityManager em) {
        return (instance == null)
                ? instance = new EstudianteRepository(em)
                : instance;
    }

    /**
     * find Student by NumeroLibreta
     *
     * @param numeroLibreta String numero de libreta del estudiante a buscar
     * @return Estudiante
     */
    @Override
    public Estudiante findEstudianteByNumeroLibreta(String numeroLibreta) throws Exception {
        try {
            this.em.getTransaction().begin();
            Estudiante estudiante = this.em.createQuery(
                            "SELECT e FROM Estudiante e WHERE e.numeroLibreta = :numeroLibreta", Estudiante.class
                    ).setParameter("numeroLibreta", numeroLibreta)
                    .getSingleResult();

            this.em.getTransaction().commit();
            return estudiante;
        } catch (NoResultException e){
            this.em.getTransaction().rollback();
            throw new Exception("\n\n[!!!ERROR!!!]\nEstudiante no encontrado\n\n");
        }catch (Exception e ){
            this.em.getTransaction().rollback();
            throw new Exception("Error al buscar estudiante");
        }

    }

    /**
     * find Student by genero
     *
     * @param genero String genero de los estudiantes
     * @return List of Estudiantes
     */
    @Override
    public List<Estudiante> findEstudiantesByGenero(String genero) {
        this.em.getTransaction().begin();

        List<Estudiante> estudiantes = this.em.createQuery(
                        "SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class
                ).setParameter("genero", genero)
                .getResultList();

        this.em.getTransaction().commit();
        return estudiantes;
    }

    /**
     * find Students by ciudad de residencia and Carrera
     *
     * @param ciudadResidencia String ciudad de residencia
     * @param carrera          Carrera carrera de los estudiantes
     * @return List of Estudiantes
     */

    @Override
    public List<Estudiante> findEstudiantesByCiudadResidenciaAndCarrera(String ciudadResidencia, Carrera carrera) {
        this.em.getTransaction().begin();

        List<Estudiante> estudiantes = this.em.createQuery(
                        "SELECT e FROM Estudiante e JOIN e.inscripciones i JOIN i.carrera c WHERE e.ciudadResidencia = :ciudadResidencia AND c = :carrera", Estudiante.class)
                .setParameter("ciudadResidencia", ciudadResidencia)
                .setParameter("carrera", carrera)
                .getResultList();

        this.em.getTransaction().commit();
        return estudiantes;
    }

    @Override
    public void deleteAll() {
        try{
            this.em.getTransaction().begin();
            this.em.createQuery("DELETE FROM Inscripciones").executeUpdate();
            this.em.getTransaction().commit();
            super.deleteAll();
        }catch (Exception e){
            this.em.getTransaction().rollback();
            throw new RuntimeException("Error al eliminar inscripciones");
        }

    }
}
