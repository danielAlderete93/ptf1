package com.proyectotorneos.domain.validators.criterios.partido;

import com.proyectotorneos.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.model.PartidoGol;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

import java.util.HashSet;
import java.util.List;

public class CriterioValidacionGolesDebenPertenecerAUnJugadorParticipante implements CriterioValidacion<Partido> {
    @Override
    public boolean esValido(Partido partido) {
        return golesFueronHechosPorJugadoresParticipantes(partido.getActuacionEquipoLocal()) ||
                golesFueronHechosPorJugadoresParticipantes(partido.getActuacionEquipoVisitante());
    }

    @Override
    public void accion() {
        throw new DomainExceptionPartido("Los goles deben pertenecer a un jugador que participo del partido");
    }

    private boolean golesFueronHechosPorJugadoresParticipantes(ActuacionEquipo actuacionEquipo) {
        List<Jugador> goleadores;
        if (actuacionEquipo.getJugadoresParticipante().isEmpty()) {
            return true;
        }

        if (actuacionEquipo.getGoles().isEmpty()) {
            return true;
        }

        goleadores = actuacionEquipo.getGoles().stream()
                .map(PartidoGol::getJugador)
                .toList();

        return new HashSet<>(actuacionEquipo.getJugadoresParticipante()).containsAll(goleadores);
    }

}
