package com.proyectotorneos.habilidad.domain.model;

import com.proyectotorneos.shared.domain.model.Identificable;
import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;
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
public class HabilidadJugador extends Identificable {
    private TipoHabilidad tipoHabilidad;
    private String nombre;
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HabilidadJugador that)) return false;
        if (!super.equals(o)) return false;

        if (getTipoHabilidad() != null ? !getTipoHabilidad().equals(that.getTipoHabilidad()) : that.getTipoHabilidad() != null)
            return false;
        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        return getDescripcion() != null ? getDescripcion().equals(that.getDescripcion()) : that.getDescripcion() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTipoHabilidad() != null ? getTipoHabilidad().hashCode() : 0);
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        return result;
    }
}
