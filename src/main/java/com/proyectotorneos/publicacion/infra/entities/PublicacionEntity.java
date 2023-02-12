package com.proyectotorneos.publicacion.infra.entities;

import com.proyectotorneos.shared.infra.entities.EntidadPersistente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "publicaciones")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class PublicacionEntity extends EntidadPersistente {
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;


}
