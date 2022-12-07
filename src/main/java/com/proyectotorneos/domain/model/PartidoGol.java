package com.proyectotorneos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PartidoGol extends Identificable{
    private Jugador jugador;
    private Integer tiempo;
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartidoGol that)) return false;
        if (!super.equals(o)) return false;

        if (getJugador() != null ? !getJugador().equals(that.getJugador()) : that.getJugador() != null) return false;
        if (getTiempo() != null ? !getTiempo().equals(that.getTiempo()) : that.getTiempo() != null) return false;
        return getDescripcion() != null ? getDescripcion().equals(that.getDescripcion()) : that.getDescripcion() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getJugador() != null ? getJugador().hashCode() : 0);
        result = 31 * result + (getTiempo() != null ? getTiempo().hashCode() : 0);
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        return result;
    }
}
