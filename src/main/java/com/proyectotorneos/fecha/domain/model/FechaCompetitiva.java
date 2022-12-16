package com.proyectotorneos.fecha.domain.model;

import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.shared.domain.model.Identificable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FechaCompetitiva extends Identificable {
    private Integer nroFecha;
    private List<Partido> partidos;

    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }


    public Stream<Partido> getPartidosFinalizados() {
        return this.partidos.stream()
                .filter(Partido::isFinalizado)

                ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaCompetitiva that)) return false;
        if (!super.equals(o)) return false;

        if (getNroFecha() != null ? !getNroFecha().equals(that.getNroFecha()) : that.getNroFecha() != null)
            return false;
        return getPartidos() != null ? getPartidos().equals(that.getPartidos()) : that.getPartidos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNroFecha() != null ? getNroFecha().hashCode() : 0);
        result = 31 * result + (getPartidos() != null ? getPartidos().hashCode() : 0);
        return result;
    }
}
