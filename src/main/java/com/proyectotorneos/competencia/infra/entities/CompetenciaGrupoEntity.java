package com.proyectotorneos.competencia.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Grupo")
public class CompetenciaGrupoEntity extends CompetenciaEntity {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "competencia_grupo_id")
    List<CompetenciaLigaEntity> grupos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaGrupoEntity that)) return false;
        if (!super.equals(o)) return false;

        return getGrupos() != null ? getGrupos().equals(that.getGrupos()) : that.getGrupos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGrupos() != null ? getGrupos().hashCode() : 0);
        return result;
    }
}
