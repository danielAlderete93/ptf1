package com.proyectotorneos.competencia.domain.model.requisitos;

import com.proyectotorneos.competencia.domain.model.Competencia;
import com.proyectotorneos.competencia.domain.model.CompetenciaConPuntuacion;
import com.proyectotorneos.equipo.domain.model.Equipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RequisitoClasificacionPorRango implements RequisitoClasificacion {
    private Integer posicionInicial;
    private Integer posicionFinal;


    @Override
    public Boolean puedeClasificar(Equipo equipo, Competencia competencia) {
        Integer posicion;
        if (competencia instanceof CompetenciaConPuntuacion competenciaConPuntuacion) {
            posicion = competenciaConPuntuacion.getPosicionEquipo(equipo);
            if (posicion == null) {
                return false;
            }
            return posicion <= posicionFinal && posicion >= posicionInicial;
        }
        return false;

    }
}
