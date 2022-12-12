package com.proyectotorneos.posicion.infra.adaptors.repositories;

import com.proyectotorneos.partido.infra.entities.PosicionJuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionJuegoRepositoryJPA extends JpaRepository<PosicionJuegoEntity, Integer> {
    @Query(value = "SELECT p FROM PosicionJuegoEntity p WHERE p.nombre = ?1")
    PosicionJuegoEntity findByName(String nombre);
}
