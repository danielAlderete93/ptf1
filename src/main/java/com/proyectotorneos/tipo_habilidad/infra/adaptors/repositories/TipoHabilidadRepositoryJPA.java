package com.proyectotorneos.tipo_habilidad.infra.adaptors.repositories;

import com.proyectotorneos.tipo_habilidad.infra.entities.TipoHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabilidadRepositoryJPA extends JpaRepository<TipoHabilidadEntity, Integer> {
    @Query(value = "SELECT t FROM TorneoEntity t WHERE t.nombre = ?1")
    TipoHabilidadEntity findByName(String nombre);
}
