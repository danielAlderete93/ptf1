package com.proyectotorneos.gol.infra.adaptors.repositories;

import com.proyectotorneos.posicion.infra.entities.PartidoGolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoGolRepositoryJPA extends JpaRepository<PartidoGolEntity, Integer> {
}
