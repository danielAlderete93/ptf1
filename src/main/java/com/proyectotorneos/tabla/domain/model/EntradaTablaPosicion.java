package com.proyectotorneos.tabla.domain.model;

import com.proyectotorneos.competencia.domain.exceptions.DomainExceptionCompetencia;
import com.proyectotorneos.equipo.domain.model.Equipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaTablaPosicion {
    private Equipo equipo;
    private Integer posicion;
    private Integer partidosJugados;
    private Integer partidosGanados;
    private Integer partidosEmpatados;
    private Integer partidosPerdidos;
    private Integer difGol;
    private Integer golAFavor;
    private Integer golEnContra;

    private Integer puntos;

    public EntradaTablaPosicion(Equipo equipo) {
        this.equipo = equipo;
        this.posicion=0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.difGol = 0;
        this.golAFavor = 0;
        this.golEnContra = 0;
        this.puntos = 0;
    }

    public void suma(EntradaTablaPosicion entradaTablaPosicion) {

        validaEntrada(entradaTablaPosicion);

        this.partidosJugados += entradaTablaPosicion.getPartidosJugados();

        this.partidosGanados += entradaTablaPosicion.getPartidosGanados();
        this.partidosEmpatados += entradaTablaPosicion.getPartidosEmpatados();
        this.partidosPerdidos += entradaTablaPosicion.getPartidosPerdidos();

        this.golAFavor = entradaTablaPosicion.getGolAFavor();
        this.golEnContra = entradaTablaPosicion.getGolEnContra();

        this.difGol = this.golAFavor - this.golEnContra;
    }

    public boolean sosEntradaDeEquipo(Equipo equipo) {
        return this.equipo.equals(equipo);
    }

    public void validaEntrada(EntradaTablaPosicion entradaTablaPosicion) {
        if (!sosEntradaDeEquipo(entradaTablaPosicion.getEquipo())) {
            throw new DomainExceptionCompetencia(
                    "Para agregar nuevos valores a la tabla, las entradas deben corresponder al  mismo equipo."
            );
        }
    }

    private void sumaPartido() {
        this.partidosJugados++;
    }

    public void sumaEmpate() {
        sumaPartido();
        this.partidosEmpatados++;
        this.puntos += 1;
    }

    public void sumaGanado() {
        sumaPartido();
        this.partidosGanados++;
        this.puntos += 3;
    }

    public void sumaPerdido() {
        sumaPartido();
        this.partidosPerdidos++;
        this.puntos += 0;
    }
}
