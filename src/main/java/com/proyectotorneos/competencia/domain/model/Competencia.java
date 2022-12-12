package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.shared.domain.model.Identificable;
import com.proyectotorneos.equipo.domain.model.Equipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

 @SuperBuilder
 @NoArgsConstructor
 @AllArgsConstructor
@Getter
@Setter
public abstract class Competencia extends Identificable {
    private List<Equipo> equipos;
    private String nombre;

    public abstract void finaliza();

    public abstract boolean puedeFinalizar();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Competencia that)) return false;
        if (!super.equals(o)) return false;

        if (getEquipos() != null ? !getEquipos().equals(that.getEquipos()) : that.getEquipos() != null) return false;
        return getNombre() != null ? getNombre().equals(that.getNombre()) : that.getNombre() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getEquipos() != null ? getEquipos().hashCode() : 0);
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        return result;
    }
}
