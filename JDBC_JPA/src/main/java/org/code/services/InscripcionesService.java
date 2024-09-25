package org.code.services;

import org.code.models.Carrera;
import org.code.models.Estudiante;
import org.code.models.Inscripciones;
import org.code.repositories.IInscripcionesRepository;
import org.code.repositories.JPARepository.InscripcionesRepository;

import java.time.Year;
import java.util.List;

public class InscripcionesService {

    private final IInscripcionesRepository inscripcionesRepository;

    private static InscripcionesService instance;

    private InscripcionesService(IInscripcionesRepository inscripcionesRepository) {
        this.inscripcionesRepository = inscripcionesRepository;
    }

    public static InscripcionesService getInstance(IInscripcionesRepository inscripcionesRepository) {
        return (instance == null)
                ? instance = new InscripcionesService(inscripcionesRepository)
                : instance;
    }

    public void inscribirAlumno(Estudiante estudiante, Carrera carrera) {
        inscripcionesRepository.save(new Inscripciones(estudiante, carrera, Year.now().getValue(), false));
    }



    ///////////


    public void inscribirAlumnoAnio(Estudiante estudiante, Carrera carrera,int anioIngreso) {
        inscripcionesRepository.save(new Inscripciones(estudiante, carrera, anioIngreso, false));
    }

//////////////////////////



    public void crearReporteDeCarreras(){
        List<Inscripciones> Lista = inscripcionesRepository.crearReporte();
        String carreraActual = Lista.getFirst().getCarrera().getNombre();
        int anioActual = Lista.getFirst().getAnioIngreso();
        System.out.println();
        System.out.println("CARRERA: " + carreraActual + " \n");
        System.out.println("AÑO DE INSCRIPCION: " + anioActual + " \n");
        System.out.println();
        for(Inscripciones i : Lista){


            if(carreraActual != i.getCarrera().getNombre()){
                carreraActual = i.getCarrera().getNombre();
                System.out.println();
                System.out.println("CARRERA: " + carreraActual + " \n");
                anioActual = 0; // resetar anio para poder poner el cartel si se repiten en la sig carrera
            }

            if(anioActual != i.getAnioIngreso()){

                anioActual = i.getAnioIngreso();
                System.out.println("ANIO DE INSCRIPCION: " + anioActual + " \n");
                System.out.println();
            }
            System.out.println();
            System.out.println(i.getEstudiante());
            System.out.println();
        }



    }

    ///////////////




    public List<Inscripciones> getAll() {
        return (List<Inscripciones>) inscripcionesRepository.findAll();
    }

    public void deleteAll() throws Exception {
        inscripcionesRepository.deleteAll();
    }
}
