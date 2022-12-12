package com.proyectotorneos.competencia.infra.entities;

import com.proyectotorneos.fecha.infra.entities.FechaCompetitivaEntity;
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
@DiscriminatorValue("Liga")
public class CompetenciaLigaEntity extends CompetenciaEntity {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "competencia_id")
    private List<FechaCompetitivaEntity> fechas;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenciaLigaEntity that)) return false;
        if (!super.equals(o)) return false;

        return getFechas() != null ? getFechas().equals(that.getFechas()) : that.getFechas() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFechas() != null ? getFechas().hashCode() : 0);
        return result;
    }
}
