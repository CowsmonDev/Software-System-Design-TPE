package org.code.repositories.JPARepository;

import org.code.models.Inscripciones;
import org.code.models.serializers.InscripcionesId;
import org.code.repositories.IInscripcionesRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class InscripcionesRepository extends Repository<Inscripciones, InscripcionesId> implements IInscripcionesRepository {


    private static InscripcionesRepository instance;

    private InscripcionesRepository(EntityManager em) {
        super(Inscripciones.class, InscripcionesId.class, em);
    }

    public static InscripcionesRepository getInstance(EntityManager em) {
        return (instance == null)
                ? instance = new InscripcionesRepository(em)
                : instance;
    }


///////////////////////////
    @Override
    public List<Inscripciones> crearReporte() {
        this.em.getTransaction().begin();
        List<Inscripciones> inscripciones = this.em.createQuery(
                "SELECT i" +
                        " FROM " +
                        "Carrera c JOIN Inscripciones i ON c = i.carrera " +
                        " JOIN Estudiante e ON i.estudiante = e " +
                        " ORDER BY "+
                        " i.carrera.nombre ASC, i.anioIngreso ASC", Inscripciones.class)
                .getResultList();

        this.em.getTransaction().commit();
        return inscripciones;
    }
//////////////////////////////////////////


}
