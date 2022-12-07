package com.proyectotorneos.infra.adaptors.repositories;

import com.proyectotorneos.infra.entities.TipoHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabilidadRepositoryJPA extends JpaRepository<TipoHabilidadEntity, Integer> {
    @Query(value = "SELECT t FROM TipoHabilidadEntity t WHERE t.nombre = ?1")
    TipoHabilidadEntity findByName(String nombre);
}
