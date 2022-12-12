package com.proyectotorneos.actuacion.domain.model;

import com.proyectotorneos.shared.domain.model.Identificable;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.equipo.domain.model.Equipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ActuacionEquipo extends Identificable {
    private Equipo equipo;
    private List<Jugador> jugadoresParticipante;
    private List<PartidoGol> goles;



    public Integer cantGoles() {
        return goles.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActuacionEquipo that)) return false;
        if (!super.equals(o)) return false;

        if (getEquipo() != null ? !getEquipo().equals(that.getEquipo()) : that.getEquipo() != null) return false;
        if (getJugadoresParticipante() != null ? !getJugadoresParticipante().equals(that.getJugadoresParticipante()) : that.getJugadoresParticipante() != null)
            return false;
        return getGoles() != null ? getGoles().equals(that.getGoles()) : that.getGoles() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getEquipo() != null ? getEquipo().hashCode() : 0);
        result = 31 * result + (getJugadoresParticipante() != null ? getJugadoresParticipante().hashCode() : 0);
        result = 31 * result + (getGoles() != null ? getGoles().hashCode() : 0);
        return result;
    }
}
