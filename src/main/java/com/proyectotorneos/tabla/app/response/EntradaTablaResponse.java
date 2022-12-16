package com.proyectotorneos.tabla.app.response;

public record EntradaTablaResponse(
        String equipo,
        Integer partidosJugados,
        Integer partidosGanados,
        Integer partidosEmpatados,
        Integer partidosPerdidos,
        Integer difGol,
        Integer golAFavor,
        Integer golEnContra,
        Integer puntos
) {
}
