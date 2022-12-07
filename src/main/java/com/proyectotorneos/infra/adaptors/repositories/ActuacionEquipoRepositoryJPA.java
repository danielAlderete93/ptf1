package com.proyectotorneos.infra.adaptors.repositories;

import com.proyectotorneos.infra.entities.ActuacionEquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuacionEquipoRepositoryJPA extends JpaRepository<ActuacionEquipoEntity, Integer> {
}
