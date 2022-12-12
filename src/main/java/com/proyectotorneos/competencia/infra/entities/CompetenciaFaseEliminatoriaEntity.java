package com.proyectotorneos.competencia.infra.entities;

import com.proyectotorneos.fecha.infra.entities.FechaCompetitivaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Eliminatoria")
public class CompetenciaFaseEliminatoriaEntity extends CompetenciaEntity {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fecha_id")
    private FechaCompetitivaEntity fecha;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competencia_fase_ganadora_id")
    private CompetenciaFaseEliminatoriaEntity proximaFaseGanadora;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competencia_fase_perdedora_id")
    private CompetenciaFaseEliminatoriaEntity proximaFasePerdedora;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaFaseEliminatoriaEntity that)) return false;
        if (!super.equals(o)) return false;

        if (getFecha() != null ? !getFecha().equals(that.getFecha()) : that.getFecha() != null) return false;
        if (getProximaFaseGanadora() != null ? !getProximaFaseGanadora().equals(that.getProximaFaseGanadora()) : that.getProximaFaseGanadora() != null)
            return false;
        return getProximaFasePerdedora() != null ? getProximaFasePerdedora().equals(that.getProximaFasePerdedora()) : that.getProximaFasePerdedora() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFecha() != null ? getFecha().hashCode() : 0);
        result = 31 * result + (getProximaFaseGanadora() != null ? getProximaFaseGanadora().hashCode() : 0);
        result = 31 * result + (getProximaFasePerdedora() != null ? getProximaFasePerdedora().hashCode() : 0);
        return result;
    }
}
