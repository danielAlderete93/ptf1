package com.proyectotorneos.habilidad.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import com.proyectotorneos.tipo_habilidad.infra.entities.TipoHabilidadEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "habilidades_jugador")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class HabilidadJugadorEntity extends EntidadPersistente {
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoHabilidadEntity tipoHabilidad;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HabilidadJugadorEntity that)) return false;
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
