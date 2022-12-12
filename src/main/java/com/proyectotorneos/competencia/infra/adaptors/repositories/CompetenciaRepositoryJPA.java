package com.proyectotorneos.competencia.infra.adaptors.repositories;

import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepositoryJPA extends JpaRepository<CompetenciaEntity, Integer> {
}
