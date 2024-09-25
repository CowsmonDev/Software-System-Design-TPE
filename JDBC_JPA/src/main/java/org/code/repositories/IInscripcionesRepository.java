package org.code.repositories;

import org.code.models.Inscripciones;
import org.code.models.serializers.InscripcionesId;

import java.util.List;

public interface IInscripcionesRepository extends IRepository<Inscripciones, InscripcionesId>{

    ///////////////////////////
    List<Inscripciones> crearReporte();
}
