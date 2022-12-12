package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
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
public class CompetenciaFaseEliminatoria extends Competencia {
    private FechaCompetitiva fecha;
    private CompetenciaFaseEliminatoria proximaFaseGanadora;
    private CompetenciaFaseEliminatoria proximaFasePerdedora;

    @Override
    public void finaliza() {

    }

    @Override
    public boolean puedeFinalizar() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaFaseEliminatoria that)) return false;
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
