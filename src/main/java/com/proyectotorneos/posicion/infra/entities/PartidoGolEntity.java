package com.proyectotorneos.posicion.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "goles")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class PartidoGolEntity extends EntidadPersistente {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador")
    private JugadorEntity jugador;
    @Column(name="tiempo")
    private Integer tiempo;
    @Column(name="descripcion")
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartidoGolEntity entity)) return false;
        if (!super.equals(o)) return false;

        if (getJugador() != null ? !getJugador().equals(entity.getJugador()) : entity.getJugador() != null)
            return false;
        if (getTiempo() != null ? !getTiempo().equals(entity.getTiempo()) : entity.getTiempo() != null) return false;
        return getDescripcion() != null ? getDescripcion().equals(entity.getDescripcion()) : entity.getDescripcion() == null;
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
