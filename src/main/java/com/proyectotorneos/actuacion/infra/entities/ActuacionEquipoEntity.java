package com.proyectotorneos.actuacion.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import com.proyectotorneos.posicion.infra.entities.PartidoGolEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actuaciones")
@Getter
@Setter
@NoArgsConstructor
public class ActuacionEquipoEntity extends EntidadPersistente {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo")
    private EquipoEntity equipo;
    @ManyToMany()
    @JoinTable(
            name = "actuacion_equipo_x_jugador",
            joinColumns = @JoinColumn(name = "actuacion_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_id"))
    private List<JugadorEntity> jugadores = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gol")
    private List<PartidoGolEntity> goles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActuacionEquipoEntity that)) return false;

        if (getEquipo() != null ? !getEquipo().equals(that.getEquipo()) : that.getEquipo() != null) return false;
        if (getJugadores() != null ? !getJugadores().equals(that.getJugadores()) : that.getJugadores() != null)
            return false;
        return getGoles() != null ? getGoles().equals(that.getGoles()) : that.getGoles() == null;
    }

    @Override
    public int hashCode() {
        int result = getEquipo() != null ? getEquipo().hashCode() : 0;
        result = 31 * result + (getJugadores() != null ? getJugadores().hashCode() : 0);
        result = 31 * result + (getGoles() != null ? getGoles().hashCode() : 0);
        return result;
    }
}
