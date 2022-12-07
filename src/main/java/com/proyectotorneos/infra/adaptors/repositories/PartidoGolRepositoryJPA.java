package com.proyectotorneos.infra.adaptors.repositories;

import com.proyectotorneos.infra.entities.PartidoGolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoGolRepositoryJPA extends JpaRepository<PartidoGolEntity, Integer> {
}
