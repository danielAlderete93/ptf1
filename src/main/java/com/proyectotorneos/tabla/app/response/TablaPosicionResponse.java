package com.proyectotorneos.tabla.app.response;

import java.util.List;

public record TablaPosicionResponse(
        Integer idTorneo,
        String nombreTorneo,
        List<EntradaTablaResponse> tabla

) {
}
