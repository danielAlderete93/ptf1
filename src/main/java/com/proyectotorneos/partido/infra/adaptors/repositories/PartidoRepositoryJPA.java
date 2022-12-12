package com.proyectotorneos.partido.infra.adaptors.repositories;

import com.proyectotorneos.gol.infra.entities.PartidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepositoryJPA extends JpaRepository<PartidoEntity, Integer> {
}
