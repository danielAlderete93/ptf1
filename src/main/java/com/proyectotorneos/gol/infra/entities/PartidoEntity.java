package com.proyectotorneos.gol.infra.entities;

import com.proyectotorneos.actuacion.infra.entities.ActuacionEquipoEntity;
import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name = "partido")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class PartidoEntity extends EntidadPersistente {
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "actuacion_equipo_local_id")
    private ActuacionEquipoEntity actuacionLocal;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "actuacion_equipo_visitante_id")
    private ActuacionEquipoEntity actuacionVisitante;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "esta_finalizado")
    private boolean finalizado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartidoEntity that)) return false;
        if (!super.equals(o)) return false;

        if (isFinalizado() != that.isFinalizado()) return false;
        if (getActuacionLocal() != null ? !getActuacionLocal().equals(that.getActuacionLocal()) : that.getActuacionLocal() != null)
            return false;
        if (getActuacionVisitante() != null ? !getActuacionVisitante().equals(that.getActuacionVisitante()) : that.getActuacionVisitante() != null)
            return false;
        return getFecha() != null ? getFecha().equals(that.getFecha()) : that.getFecha() == null;
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
