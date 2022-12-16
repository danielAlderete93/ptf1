package com.proyectotorneos.jugador.infra.entities;

import com.proyectotorneos.habilidad.infra.entities.HabilidadJugadorEntity;
import com.proyectotorneos.partido.infra.entities.PosicionJuegoEntity;
import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jugadores")
@SuperBuilder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class JugadorEntity extends EntidadPersistente {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posicion_favorita")
    private PosicionJuegoEntity posicionFavorita;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posicion_opcional")
    private PosicionJuegoEntity posicionOpcional;
    @Column(name = "habilidad_piernas")
    private String habilidadPiernas;
    @ManyToMany()
    @JoinTable(
            name = "habilidad_x_jugador",
            joinColumns = @JoinColumn(name = "jugador_id"),
            inverseJoinColumns = @JoinColumn(name = "habilidad_id"))
    private List<HabilidadJugadorEntity> habilidades;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JugadorEntity entity)) return false;
        if (!super.equals(o)) return false;

        if (getNombre() != null ? !getNombre().equals(entity.getNombre()) : entity.getNombre() != null) return false;
        if (getFechaNacimiento() != null ? !getFechaNacimiento().equals(entity.getFechaNacimiento()) : entity.getFechaNacimiento() != null)
            return false;
        if (getPosicionFavorita() != null ? !getPosicionFavorita().equals(entity.getPosicionFavorita()) : entity.getPosicionFavorita() != null)
            return false;
        if (getPosicionOpcional() != null ? !getPosicionOpcional().equals(entity.getPosicionOpcional()) : entity.getPosicionOpcional() != null)
            return false;
        if (getHabilidadPiernas() != null ? !getHabilidadPiernas().equals(entity.getHabilidadPiernas()) : entity.getHabilidadPiernas() != null)
            return false;
        return getHabilidades() != null ? getHabilidades().equals(entity.getHabilidades()) : entity.getHabilidades() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getFechaNacimiento() != null ? getFechaNacimiento().hashCode() : 0);
        result = 31 * result + (getPosicionFavorita() != null ? getPosicionFavorita().hashCode() : 0);
        result = 31 * result + (getPosicionOpcional() != null ? getPosicionOpcional().hashCode() : 0);
        result = 31 * result + (getHabilidadPiernas() != null ? getHabilidadPiernas().hashCode() : 0);
        result = 31 * result + (getHabilidades() != null ? getHabilidades().hashCode() : 0);
        return result;
    }
}
