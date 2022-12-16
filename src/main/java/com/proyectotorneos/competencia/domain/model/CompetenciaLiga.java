package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.tabla.domain.model.EntradaTablaPosicion;
import com.proyectotorneos.tabla.domain.model.TablaPosicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaLiga extends Competencia implements CompetenciaConPuntuacion {
    private List<FechaCompetitiva> fechas;


    @Override
    public void finaliza() {
        // TODO A implementar
    }

    @Override
    public boolean puedeFinalizar() {
        return false;
    }

    @Override
    public List<EntradaTablaPosicion> getTabla() {
        TablaPosicion tablaPosicion = new TablaPosicion();
        return tablaPosicion.getTablaSegun(this.getEquipos(), this.fechas);
    }

    @Override
    public List<List<EntradaTablaPosicion>> getAllTablas() {
        throw new UnsupportedOperationException("Las ligas solo tiene una tabla de posiciones");
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
