package com.proyectotorneos.torneo.infra.entities;

import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "torneo")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class TorneoEntity extends EntidadPersistente {


    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    /*TODO: UsuarioAsignados*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Competencia_FK")
    private CompetenciaEntity competencia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TorneoEntity that)) return false;
        if (!super.equals(o)) return false;

        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        return getCompetencia() != null ? getCompetencia().equals(that.getCompetencia()) : that.getCompetencia() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getCompetencia() != null ? getCompetencia().hashCode() : 0);
        return result;
    }
}
