package org.code.models.serializers;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InscripcionesId implements Serializable {
    private String numeroDocumento;
    private int idCarrera;

    public InscripcionesId() {
    }

    public InscripcionesId(String numeroDocumento, int idCarrera) {
        this.numeroDocumento = numeroDocumento;
        this.idCarrera = idCarrera;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        InscripcionesId that = (InscripcionesId) obj;

        return Objects.equals(numeroDocumento, that.numeroDocumento) && idCarrera == that.idCarrera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDocumento, idCarrera);
    }
}
