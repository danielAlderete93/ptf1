package com.proyectotorneos.fecha.infra.adaptors.repositories;

import com.proyectotorneos.fecha.infra.entities.FechaCompetitivaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FechaCompetitivaRepositoryJPA extends JpaRepository<FechaCompetitivaEntity, Integer> {
}
