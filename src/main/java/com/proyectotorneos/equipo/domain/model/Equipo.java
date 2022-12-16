package com.proyectotorneos.equipo.domain.model;

import com.proyectotorneos.shared.domain.model.Identificable;
import com.proyectotorneos.jugador.domain.model.Jugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Equipo extends Identificable {
    private String nombre;
    private String urlEscudo;
    private String urlPlantel;
    private List<Jugador> jugadores;


    public boolean tenesJugador(Jugador jugador) {
        return this.getJugadores().contains(jugador);
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;
        if (!super.equals(o)) return false;

        if (getNombre() != null ? !getNombre().equals(equipo.getNombre()) : equipo.getNombre() != null) return false;
        if (getUrlEscudo() != null ? !getUrlEscudo().equals(equipo.getUrlEscudo()) : equipo.getUrlEscudo() != null)
            return false;
        if (getUrlPlantel() != null ? !getUrlPlantel().equals(equipo.getUrlPlantel()) : equipo.getUrlPlantel() != null)
            return false;
        return getJugadores() != null ? getJugadores().equals(equipo.getJugadores()) : equipo.getJugadores() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getUrlEscudo() != null ? getUrlEscudo().hashCode() : 0);
        result = 31 * result + (getUrlPlantel() != null ? getUrlPlantel().hashCode() : 0);
        result = 31 * result + (getJugadores() != null ? getJugadores().hashCode() : 0);
        return result;
    }
}
