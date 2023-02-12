package com.proyectotorneos.torneo.infra.repositories;

import com.proyectotorneos.torneo.infra.entities.TorneoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepositoryJPA extends JpaRepository<TorneoEntity, Integer> {

}
