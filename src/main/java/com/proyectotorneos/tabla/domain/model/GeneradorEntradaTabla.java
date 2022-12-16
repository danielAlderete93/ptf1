package com.proyectotorneos.tabla.domain.model;

import com.proyectotorneos.partido.domain.model.Partido;

import java.util.Arrays;
import java.util.List;

/*
 * Tabla posicion
 * pos| nombre| escudito|pj|pg|pe|pp|gf|ge|dg
 *
 *
 *
 * */


public class GeneradorEntradaTabla {

    public List<EntradaTablaPosicion> getEntradasTablaSegun(Partido partido) {

        EntradaTablaPosicion entradaLocales = new EntradaTablaPosicion(partido.getEquipoLocal());
        EntradaTablaPosicion entradaVisitante = new EntradaTablaPosicion(partido.getEquipoVisitante());
        List<EntradaTablaPosicion> entradas = Arrays.asList(entradaLocales, entradaVisitante);

        if (!partido.isFinalizado()) {
            return entradas;
        }


        sumaGoles(entradaLocales, partido.cantGolesLocales(), partido.cantGolesVisitante());

        sumaGoles(entradaVisitante, partido.cantGolesVisitante(), partido.cantGolesLocales());

        sumaPartidos(partido, entradaLocales, entradaVisitante);

        return entradas;
    }

    private void sumaGoles(EntradaTablaPosicion entrada, Integer golAFavor, Integer golEnContra) {
        entrada.setGolAFavor(golAFavor);
        entrada.setGolEnContra(golEnContra);
    }

    private void sumaPartidos(Partido partido, EntradaTablaPosicion entradaLocales, EntradaTablaPosicion entradaVisitante) {
        if (partido.fueEmpate()) {
            entradaLocales.sumaEmpate();
            entradaVisitante.sumaEmpate();
        }

        if (partido.ganaronLocales()) {
            entradaLocales.sumaGanado();
            entradaVisitante.sumaPerdido();
        }

        if (partido.ganaronVisitante()) {
            entradaLocales.sumaPerdido();
            entradaVisitante.sumaGanado();
        }
    }


}
