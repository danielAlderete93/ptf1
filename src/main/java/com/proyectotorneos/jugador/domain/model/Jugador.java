package com.proyectotorneos.jugador.domain.model;

import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import com.proyectotorneos.shared.domain.model.Identificable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Jugador extends Identificable {
    private String nombre;
    private LocalDate fechaNacimiento;
    private PosicionJuego posicionFavorita;
    private PosicionJuego posicionOpcional;
    private String habilidadPiernas;
    private List<HabilidadJugador> habilidades;

    public Boolean tieneMismaPosicion() {
        return posicionFavorita.getId().equals(posicionOpcional.getId());
    }

    public Long getEdad() {

        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador jugador)) return false;

        if (getNombre() != null ? !getNombre().equals(jugador.getNombre()) : jugador.getNombre() != null) return false;
        if (getFechaNacimiento() != null ? !getFechaNacimiento().equals(jugador.getFechaNacimiento()) : jugador.getFechaNacimiento() != null)
            return false;
        if (getPosicionFavorita() != null ? !getPosicionFavorita().equals(jugador.getPosicionFavorita()) : jugador.getPosicionFavorita() != null)
            return false;
        if (getPosicionOpcional() != null ? !getPosicionOpcional().equals(jugador.getPosicionOpcional()) : jugador.getPosicionOpcional() != null)
            return false;
        if (getHabilidadPiernas() != null ? !getHabilidadPiernas().equals(jugador.getHabilidadPiernas()) : jugador.getHabilidadPiernas() != null)
            return false;
        return getHabilidades() != null ? getHabilidades().equals(jugador.getHabilidades()) : jugador.getHabilidades() == null;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", posicionFavorita=" + posicionFavorita.getId() +
                ", posicionOpcional=" + posicionOpcional.getId() +
                ", habilidadPiernas='" + habilidadPiernas + '\'' +
                ", habilidades=" + habilidades.stream().map(habilidadJugador -> habilidadJugador.getId()) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getFechaNacimiento() != null ? getFechaNacimiento().hashCode() : 0);
        result = 31 * result + (getPosicionFavorita() != null ? getPosicionFavorita().hashCode() : 0);
        result = 31 * result + (getPosicionOpcional() != null ? getPosicionOpcional().hashCode() : 0);
        result = 31 * result + (getHabilidadPiernas() != null ? getHabilidadPiernas().hashCode() : 0);
        result = 31 * result + (getHabilidades() != null ? getHabilidades().hashCode() : 0);
        return result;
    }
}
