package com.proyectotorneos.fecha.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import com.proyectotorneos.gol.infra.entities.PartidoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "fechas_competitivas")
@Getter
@Setter
@NoArgsConstructor
public class FechaCompetitivaEntity extends EntidadPersistente {

    @Column(name = "nro_fecha")
    private Integer nroFecha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fecha_id")
    private List<PartidoEntity> partidos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaCompetitivaEntity that)) return false;
        if (!super.equals(o)) return false;

        if (getNroFecha() != null ? !getNroFecha().equals(that.getNroFecha()) : that.getNroFecha() != null)
            return false;
        return getPartidos() != null ? getPartidos().equals(that.getPartidos()) : that.getPartidos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNroFecha() != null ? getNroFecha().hashCode() : 0);
        result = 31 * result + (getPartidos() != null ? getPartidos().hashCode() : 0);
        return result;
    }
}
