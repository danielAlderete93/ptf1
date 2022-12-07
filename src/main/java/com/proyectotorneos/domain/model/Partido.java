package com.proyectotorneos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Partido extends Identificable {
    private ActuacionEquipo actuacionEquipoLocal;
    private ActuacionEquipo actuacionEquipoVisitante;
    private Date fecha;
    private boolean finalizado;

    public Integer cantGolesLocales() {
        return actuacionEquipoLocal.cantGoles();
    }

    public Integer cantGolesVisitante() {
        return actuacionEquipoVisitante.cantGoles();
    }

    public void finaliza() {
        this.setFinalizado(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;
        if (!super.equals(o)) return false;

        if (isFinalizado() != partido.isFinalizado()) return false;
        if (getActuacionEquipoLocal() != null ? !getActuacionEquipoLocal().equals(partido.getActuacionEquipoLocal()) : partido.getActuacionEquipoLocal() != null)
            return false;
        if (getActuacionEquipoVisitante() != null ? !getActuacionEquipoVisitante().equals(partido.getActuacionEquipoVisitante()) : partido.getActuacionEquipoVisitante() != null)
            return false;
        return getFecha() != null ? getFecha().equals(partido.getFecha()) : partido.getFecha() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getActuacionEquipoLocal() != null ? getActuacionEquipoLocal().hashCode() : 0);
        result = 31 * result + (getActuacionEquipoVisitante() != null ? getActuacionEquipoVisitante().hashCode() : 0);
        result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
        result = 31 * result + (isFinalizado() ? 1 : 0);
        return result;
    }
}
