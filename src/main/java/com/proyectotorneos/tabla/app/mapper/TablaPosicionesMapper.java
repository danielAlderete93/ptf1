package com.proyectotorneos.tabla.app.mapper;

import com.proyectotorneos.tabla.app.response.EntradaTablaResponse;
import com.proyectotorneos.tabla.app.response.TablaPosicionResponse;
import com.proyectotorneos.tabla.domain.model.EntradaTablaPosicion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TablaPosicionesMapper {

    public TablaPosicionResponse toResponse(List<EntradaTablaPosicion> tabla, String nombreLiga, Integer idLiga) {
        List<EntradaTablaResponse> tablaResponses;

        tablaResponses = tabla.stream().map(
                this::toResponse
        ).toList();

        return new TablaPosicionResponse(
                idLiga,
                nombreLiga,
                tablaResponses
        );
    }


    private EntradaTablaResponse toResponse(EntradaTablaPosicion entradaTablaPosicion) {

        return new EntradaTablaResponse(
                entradaTablaPosicion.getEquipo().getNombre(),
                entradaTablaPosicion.getPartidosJugados(),
                entradaTablaPosicion.getPartidosGanados(),
                entradaTablaPosicion.getPartidosEmpatados(),
                entradaTablaPosicion.getPartidosPerdidos(),
                entradaTablaPosicion.getDifGol(),
                entradaTablaPosicion.getGolAFavor(),
                entradaTablaPosicion.getGolEnContra(),
                entradaTablaPosicion.getPuntos()
        );
    }


}
