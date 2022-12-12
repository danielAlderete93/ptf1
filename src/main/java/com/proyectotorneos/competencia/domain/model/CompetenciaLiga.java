package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaLiga extends Competencia {
    private List<FechaCompetitiva> fechas;
    // private List<Competencia> siguienteCompetencia;
    // private List<Competencia> anteriorCompetencia;
    /*
     * todo: pensar clasificacion -> con criterios para clasificar alli y la proxima competencia
     * */


    @Override
    public void finaliza() {
        // TODO A implementar
    }

    @Override
    public boolean puedeFinalizar() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaLiga that)) return false;
        if (!super.equals(o)) return false;

        return getFechas() != null ? getFechas().equals(that.getFechas()) : that.getFechas() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFechas() != null ? getFechas().hashCode() : 0);
        return result;
    }
}
