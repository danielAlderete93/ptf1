package com.proyectotorneos.infra.adaptors.repositories;

import com.proyectotorneos.infra.entities.PartidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepositoryJPA extends JpaRepository<PartidoEntity, Integer> {
}
