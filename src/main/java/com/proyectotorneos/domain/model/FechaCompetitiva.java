package com.proyectotorneos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FechaCompetitiva extends Identificable {
    private Integer nroFecha;
    private List<Partido> partidos;

    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaCompetitiva that)) return false;
        if (!super.equals(o)) return false;

        if (getNroFecha() != null ? !getNroFecha().equals(that.getNroFecha()) : that.getNroFecha() != null)
            return false;
        return getPartidos() != null ? getPartidos().equals(that.getPartidos()) : that.getPartidos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNroFecha() != null ? getNroFecha().hashCode() : 0);
        result = 31 * result + (getPartidos() != null ? getPartidos().hashCode() : 0);
        return result;
    }
}
