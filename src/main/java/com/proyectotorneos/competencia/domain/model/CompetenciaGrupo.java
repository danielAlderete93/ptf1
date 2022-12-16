package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.tabla.domain.model.EntradaTablaPosicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaGrupo extends Competencia implements CompetenciaConPuntuacion {
    List<CompetenciaLiga> grupos;


    @Override
    public void finaliza() {
        // TODO a implementar
    }

    @Override
    public boolean puedeFinalizar() {
        return false;
    }

    @Override
    public List<EntradaTablaPosicion> getTabla() {
        throw new UnsupportedOperationException("Los grupos tiene varias tabla de posiciones");
    }

    @Override
    public List<List<EntradaTablaPosicion>> getAllTablas() {

        return this.grupos.stream()
                .map(CompetenciaLiga::getTabla)
                .collect(Collectors.toList())
                ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaGrupo that)) return false;
        if (!super.equals(o)) return false;

        return getGrupos() != null ? getGrupos().equals(that.getGrupos()) : that.getGrupos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGrupos() != null ? getGrupos().hashCode() : 0);
        return result;
    }


}
