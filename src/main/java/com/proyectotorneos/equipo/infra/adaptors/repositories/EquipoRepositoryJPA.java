package com.proyectotorneos.equipo.infra.adaptors.repositories;

import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepositoryJPA extends JpaRepository<EquipoEntity, Integer> {
}
