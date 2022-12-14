package com.proyectotorneos.jugador.infra.adaptors.repositories;

import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepositoryJPA extends JpaRepository<JugadorEntity, Integer> {

}
