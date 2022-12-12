package com.proyectotorneos.competencia.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "competencias")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_competencia",
        discriminatorType = DiscriminatorType.STRING)
public abstract class CompetenciaEntity extends EntidadPersistente {
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany()
    @JoinTable(
            name = "competencia_x_equipo",
            joinColumns = @JoinColumn(name = "equipo_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id"))
    private List<EquipoEntity> equipos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaEntity that)) return false;
        if (!super.equals(o)) return false;

        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        return getEquipos() != null ? getEquipos().equals(that.getEquipos()) : that.getEquipos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getEquipos() != null ? getEquipos().hashCode() : 0);
        return result;
    }
}
