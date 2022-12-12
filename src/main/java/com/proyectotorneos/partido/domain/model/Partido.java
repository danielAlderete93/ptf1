package com.proyectotorneos.partido.domain.model;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.shared.domain.model.Identificable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Partido extends Identificable {
    private ActuacionEquipo actuacionLocal;
    private ActuacionEquipo actuacionVisitante;
    private Date fecha;
    private boolean finalizado;

    public Integer cantGolesLocales() {
        return actuacionLocal.cantGoles();
    }

    public Integer cantGolesVisitante() {
        return actuacionVisitante.cantGoles();
    }

    public String getNombreLocales() {
        return this.actuacionLocal.getEquipo().getNombre();
    }

    public String getNombreVisitante() {
        return this.actuacionVisitante.getEquipo().getNombre();
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
        if (getActuacionLocal() != null ? !getActuacionLocal().equals(partido.getActuacionLocal()) : partido.getActuacionLocal() != null)
            return false;
        if (getActuacionVisitante() != null ? !getActuacionVisitante().equals(partido.getActuacionVisitante()) : partido.getActuacionVisitante() != null)
            return false;
        return getFecha() != null ? getFecha().equals(partido.getFecha()) : partido.getFecha() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getActuacionLocal() != null ? getActuacionLocal().hashCode() : 0);
        result = 31 * result + (getActuacionVisitante() != null ? getActuacionVisitante().hashCode() : 0);
        result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
        result = 31 * result + (isFinalizado() ? 1 : 0);
        return result;
    }
}
