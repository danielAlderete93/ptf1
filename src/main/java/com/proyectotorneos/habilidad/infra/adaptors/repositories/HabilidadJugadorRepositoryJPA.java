package com.proyectotorneos.habilidad.infra.adaptors.repositories;

import com.proyectotorneos.habilidad.infra.entities.HabilidadJugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadJugadorRepositoryJPA extends JpaRepository<HabilidadJugadorEntity, Integer> {
    @Query(value = "SELECT h FROM HabilidadJugadorEntity h WHERE h.nombre = ?1")
    HabilidadJugadorEntity findByName(String name);
}
