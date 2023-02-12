package com.proyectotorneos.publicacion.domain.model;

import com.proyectotorneos.shared.domain.model.Identificable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publicacion extends Identificable {
    private String titulo;
    private String descripcion;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicacion that)) return false;
        if (!super.equals(o)) return false;

        if (getTitulo() != null ? !getTitulo().equals(that.getTitulo()) : that.getTitulo() != null) return false;
        return getDescripcion() != null ? getDescripcion().equals(that.getDescripcion()) : that.getDescripcion() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitulo() != null ? getTitulo().hashCode() : 0);
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        return result;
    }
}
