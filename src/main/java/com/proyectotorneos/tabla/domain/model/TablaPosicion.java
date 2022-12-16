package com.proyectotorneos.tabla.domain.model;

import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.partido.domain.model.Partido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TablaPosicion {
    private GeneradorEntradaTabla generadorEntradaTabla;


    public List<EntradaTablaPosicion> getTablaSegun(List<Equipo> equipos, List<FechaCompetitiva> fechas) {
        List<EntradaTablaPosicion> tabla;

        tabla = inicializaTabla(equipos);

        fechas.stream()
                .flatMap(FechaCompetitiva::getPartidosFinalizados)
                .forEach(p -> sumaPartidoATabla(tabla, p))
        ;

        return tabla;
    }


    private List<EntradaTablaPosicion> inicializaTabla(List<Equipo> equipos) {
        return equipos.stream()
                .map(EntradaTablaPosicion::new)
                .collect(Collectors.toList())
                ;
    }

    private void sumaPartidoATabla(List<EntradaTablaPosicion> tabla, Partido partido) {
        List<EntradaTablaPosicion> nuevasEntradas;
        nuevasEntradas = generadorEntradaTabla.getEntradasTablaSegun(partido);
        nuevasEntradas.forEach(e -> sumaEntradasATabla(tabla, e));
    }

    private void sumaEntradasATabla(List<EntradaTablaPosicion> tabla, EntradaTablaPosicion entradaNueva) {
        EntradaTablaPosicion entradaTabla;
        entradaTabla = tabla.stream()
                .filter(t -> t.sosEntradaDeEquipo(entradaNueva.getEquipo()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("El equipo de la entrada no esta presente en la tabla"));

        entradaTabla.suma(entradaTabla);

    }


}
