package com.proyectotorneos.competencia.domain.model;

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
public class CompetenciaGrupo extends Competencia{
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
