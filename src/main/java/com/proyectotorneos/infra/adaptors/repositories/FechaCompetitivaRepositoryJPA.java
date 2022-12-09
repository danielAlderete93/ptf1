package com.proyectotorneos.infra.adaptors.repositories;

import com.proyectotorneos.infra.entities.FechaCompetitivaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FechaCompetitivaRepositoryJPA extends JpaRepository<FechaCompetitivaEntity, Integer> {
}
