package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.equipo.domain.model.Equipo;
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
public class CompetenciaGrupo extends Competencia implements CompetenciaConPuntuacion<List<EntradaTablaPosicion>> {
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
    public List<List<EntradaTablaPosicion>> getTabla() {
        return this.grupos.stream()
                .map(CompetenciaLiga::getTabla)
                .collect(Collectors.toList())
                ;
    }


    @Override
    public Integer getPosicionEquipo(Equipo equipo) {
        CompetenciaLiga competenciaDelEquipo = this.grupos.stream()
                .filter(competenciaLiga -> competenciaLiga.equipoJuegaEnCompetencia(equipo))
                .findFirst()
                .orElse(null);
        if (competenciaDelEquipo == null) {
            return null;
        }
        return competenciaDelEquipo.getPosicionEquipo(equipo);
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
