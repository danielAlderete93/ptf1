package com.proyectotorneos.infra.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "partido")
@Getter
@Setter
@NoArgsConstructor
public class PartidoEntity extends EntidadPersistente {
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "actuacion_equipo_local_id")
    private ActuacionEquipoEntity equipoLocal;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "actuacion_equipo_visitante_id")
    private ActuacionEquipoEntity equipoVisitante;
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
        if (getEquipoLocal() != null ? !getEquipoLocal().equals(that.getEquipoLocal()) : that.getEquipoLocal() != null)
            return false;
        if (getEquipoVisitante() != null ? !getEquipoVisitante().equals(that.getEquipoVisitante()) : that.getEquipoVisitante() != null)
            return false;
        return getFecha() != null ? getFecha().equals(that.getFecha()) : that.getFecha() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getEquipoLocal() != null ? getEquipoLocal().hashCode() : 0);
        result = 31 * result + (getEquipoVisitante() != null ? getEquipoVisitante().hashCode() : 0);
        result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
        result = 31 * result + (isFinalizado() ? 1 : 0);
        return result;
    }
}
