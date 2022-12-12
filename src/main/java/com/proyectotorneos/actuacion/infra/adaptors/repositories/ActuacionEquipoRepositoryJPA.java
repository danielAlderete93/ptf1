package com.proyectotorneos.actuacion.infra.adaptors.repositories;

import com.proyectotorneos.actuacion.infra.entities.ActuacionEquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuacionEquipoRepositoryJPA extends JpaRepository<ActuacionEquipoEntity, Integer> {
}
