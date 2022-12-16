package com.proyectotorneos.posicion.domain.model;

import com.proyectotorneos.shared.domain.model.Identificable;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PosicionJuego extends Identificable {
    private String nombre;
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PosicionJuego that)) return false;
        if (!super.equals(o)) return false;

        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        return getDescripcion() != null ? getDescripcion().equals(that.getDescripcion()) : that.getDescripcion() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        return result;
    }
}
