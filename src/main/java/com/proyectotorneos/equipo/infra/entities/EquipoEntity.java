package com.proyectotorneos.equipo.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "equipo")
@Getter
@Setter
@NoArgsConstructor
public class EquipoEntity extends EntidadPersistente {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "url_escudo")
    private String urlEscudo;
    @Column(name = "url_plantel")
    private String urlPlantel;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id")
    private List<JugadorEntity> jugadores;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipoEntity that)) return false;
        if (!super.equals(o)) return false;

        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        if (getUrlEscudo() != null ? !getUrlEscudo().equals(that.getUrlEscudo()) : that.getUrlEscudo() != null)
            return false;
        if (getUrlPlantel() != null ? !getUrlPlantel().equals(that.getUrlPlantel()) : that.getUrlPlantel() != null)
            return false;
        return getJugadores() != null ? getJugadores().equals(that.getJugadores()) : that.getJugadores() == null;
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
